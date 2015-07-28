(ns mrmcc3.boot-slack
  (:require [boot.core :refer :all]
            [clj-http.client :as http]
            [cheshire.core :as json]))

(deftask slack
  "send a message to slack via incomming webhook."
  [u url URL str "slack webhook url"
   b bot BOT str "the bot username"
   m msg MSG str "message to send"
   i icon ICON str  "icon emoji (:shipit:)"
   c ch CHAN str "channel (#channel, @username)"]
  (with-pre-wrap fs
    (let [payload {:text       (or msg "no text")
                   :channel    (or ch "#general")
                   :username   (or bot "boot-slack")
                   :icon_emoji (or icon ":shipit:")}]
      (http/post url {:body (json/encode payload)}))
    fs))

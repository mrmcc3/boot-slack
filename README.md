# boot-slack

Boot task for sending a message to slack (via incoming webhook).

### Usage

in build.boot
```clj
(set-env! :dependencies '[[mrmcc3/boot-slack "0.1.0"]])
(require '[mrmcc3.boot-slack :refer [slack]])
```

then set the webhook url
```clj
(task-options! slack {:url "https://hooks.slack.com/services/.........."})
```

try it from the command line
```bash
$ boot slack -m "Hello World"
```

You can set the bot username, icon emoji and the channel/user to send to
```clj
[u url URL str "slack webhook url"
 b bot BOT str "the bot username"
 m msg MSG str "message to send"
 i icon ICON str  "icon emoji (:shipit:)"
 c ch CHAN str "channel (#channel, @username)"]
```

### LICENSE

Copyright © 2015 Michael McClintock

Distributed under the Eclipse Public License, the same as Clojure.

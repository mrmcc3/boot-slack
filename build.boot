(def +project+ 'mrmcc3/boot-slack)
(def +version+ "0.1.0-SNAPSHOT")

(set-env!
  :project +project+
  :version +version+
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure "1.7.0" :scope "provided"]
                  [boot/core "2.1.2" :scope "provided"]
                  [clj-http "2.0.0"]
                  [cheshire "5.5.0"]
                  [environ "1.0.0" :scope "test"]
                  [adzerk/bootlaces "0.1.10" :scope "test"]])

(require '[adzerk.bootlaces :refer :all]
         '[environ.core :refer [env]]
         '[mrmcc3.boot-slack :refer [slack]])

(bootlaces! +version+)

(task-options!
  pom {:project     +project+
       :version     +version+
       :description "Boot task for sending a message to slack (via incoming webhook)"
       :url         "https://github.com/mrmcc3/boot-slack"
       :scm         {:url "https://github.com/mrmcc3/boot-slack"}
       :license     {"Eclipse Public License" "http://www.eclipse.org/legal/epl-v10.html"}}

  ;; for testing
  slack {:url (env :slack-url) :ch "@michael"})

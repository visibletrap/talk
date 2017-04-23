(defproject tcm1-debug "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha15"]
                 [ring/ring-core "1.6.0-RC1"]
                 [ring/ring-jetty-adapter "1.6.0-RC1"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.5.2"]
                 [org.clojure/java.jdbc "0.7.0-alpha3"]
                 [org.postgresql/postgresql "42.0.0"]
                 [org.clojure/core.async "0.3.442"]]
  :profiles {:dev {:dependencies [[tubular "1.1.1"]]}
             :uberjar {:aot [tcm1-debug.core]
                       :main tcm1-debug.core}})

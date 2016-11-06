(defproject codemania "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.293"]
                 [reagent "0.6.0"]]

  :plugins [[lein-ring "0.9.7"]
            [lein-figwheel "0.5.8"]
            [lein-cljsbuild "1.1.4" :exclusions [[org.clojure/clojure]]]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :ring {:handler codemania.core/handler}

  :figwheel {:css-dirs ["resources/public/css"]}

  :cljsbuild
  {:builds
   [{:id "dev"
     :source-paths ["src"]
     :figwheel {:on-jsload "codemania.frontend/start"
                :open-urls ["http://localhost:3449/index.html"]}
     :compiler {:main codemania.frontend
                :asset-path "js/compiled/out"
                :output-to "resources/public/js/compiled/main.js"
                :output-dir "resources/public/js/compiled/out"
                :source-map-timestamp true}}]})

{:dev
 {:source-paths ["script"]
  :dependencies [[binaryage/devtools "0.8.2"]
                 [figwheel-sidecar "0.5.8"]]
  :cljsbuild
  {:builds ^:replace
   [{:id "dev"
     :source-paths ["src"]
     :figwheel {:on-jsload "codemania.frontend/start"
                :open-urls ["http://localhost:3449/index.html"]}
     :compiler {:main codemania.frontend
                :asset-path "js/compiled/out"
                :output-to "resources/public/js/compiled/main.js"
                :output-dir "resources/public/js/compiled/out"
                :source-map-timestamp true
                :preloads [devtools.preload]}}]}}}

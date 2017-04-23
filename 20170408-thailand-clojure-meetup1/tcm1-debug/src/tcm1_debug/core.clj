(ns tcm1-debug.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [tcm1-debug.model :as model])
  (:gen-class))

(defonce request-count (atom 0))

(comment @request-count)

(defn handler [request]
  (swap! request-count #(+ 2 %))
  (response (model/users)))

(defn start-server [dev?]
  (let [h (wrap-json-response #'handler)]
    (run-jetty h {:port 3000 :join? (not dev?)})))

(defn -main []
  (start-server false))

(defonce server (atom nil))

(comment
  (reset! server (start-server true))
  (.stop @server)
  )

(ns wongnai.web
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.util.response :refer [response]]
            [compojure.core :refer [defroutes GET]]))

(defroutes handler
  (GET "/myweb" [] (response {:x 2}))
  (GET "/with-param/:p" [p] (response {:p p})))

(defn start-server []
  (let [h (wrap-json-response #'handler)]
    (run-jetty h {:port 3000 :join? false})))

(defonce server (atom nil))

(comment
  (reset! server (start-server))
  (.stop @server)
  )

(ns tcm1-debug.model
  (:require [clojure.java.jdbc :as sql]
            [tcm1-debug.database :as db]))

(defn create-user [username password]
  (first (sql/insert! db/uri :users {:username username :password password})))

(defn users []
  (map #(dissoc % :password) (sql/query db/uri ["select * from users"])))

(comment (users))

(defn assign-user-role [user-id role]
  (sql/update! db/uri :users {:role role} ["id = ?" user-id]))

(defn get-user-role [user-id]
  (-> (sql/get-by-id db/uri :users user-id) :role))

(comment
  (defonce u (atom nil))
  (reset! u (create-user "donald" "password"))
  (assign-user-role (:id @u) "admin")
  (get-user-role (:id @u))
  )

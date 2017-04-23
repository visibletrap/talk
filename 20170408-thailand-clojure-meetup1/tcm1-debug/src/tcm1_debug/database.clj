(ns tcm1-debug.database
  (:require [clojure.java.shell :refer [sh]]
            [clojure.java.jdbc :as sql]))

(def dbname "tcm1_debug")
(def uri (str "postgresql://localhost:5432/" dbname))

(defn createdb []
  (sh "createdb" dbname))

(defn dropdb []
  (sh "dropdb" dbname))

(defn install-schema []
  (sql/execute! uri ["create table users (id serial, username text, password text, role text)"]))

(comment
  (do (createdb)
      (install-schema))

  (dropdb)
  )

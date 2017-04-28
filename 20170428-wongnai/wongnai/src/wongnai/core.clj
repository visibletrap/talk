(ns wongnai.core
  (:import [java.util HashMap]))

(+ 1 2 3)

(defn say-hello [name]
  (println "Hello," name))

(say-hello "Wongnai")





(java.util.Collections/binarySearch (map-indexed vector (range 0 100 2)) 56)

(java.util.UUID/randomUUID)

(.replace "wongnai" "o" "a")

(doto (HashMap.)
  (.put "a" 1) 
  (.put "b" 2))



(def a {:weight 65
        :height 180})

(assoc a :weight 70)
(update a :weight + 6) ; Note: pass + as an argument

(def stock
  {:walmart
   {:california
    {:mountain-view
     {:showers
      {:shirt
       [{:color :red
         :quantity 50}
        {:color :black
         :quantity 20}]}}}}})

(update-in stock
           [:walmart :california :mountain-view :showers :shirt 1 :quantity]
           - 5)




;; Switch back to presentation!




(def orders [{:item1 1 :item2 2} {:item1 3 :item3 5}])


(fn [result order]
  (merge-with + result order))

(def order-report
  (reduce (fn [result order] (merge-with + result order)) {} orders))

(def prices {:item1 40
             :item2 100
             :item3 20})

;; Calculate earning by item


(def earnings (merge-with * order-report prices))

;; Calculate total earning


(reduce + (vals earnings))


(require '[clojure.data :refer [diff]])

(diff {:color [:red :black :green]} {:color [:red :blue :green]})




;; Switch back to presentation!



(def a (atom {:weight 61
              :height 164}))

(deref a)
@a

(assoc @a :weight 60 :height 165)

(swap! a assoc :weight 60 :height 165)

@a



;; Switch back to presentation!



(when (> 2 5)
  (println "Greater than"))

(macroexpand-1 `(when (> 5 2) (println "Greater than")))

(if true "true" "false")
(if false "true" "false")




(time (+ 1 2))
(time 3)


(let [a 1
      b 2]
  [a b])

(clojure.pprint/pprint
  (macroexpand-1 `(doto (HashMap.)
                    (.put "a" 1)
                    (.put "b" 2))))


;; Switch back to presentation!

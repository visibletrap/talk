(ns codemania.core
  (:require [clojure.pprint :refer [pprint]]
            [clojure.core.async :refer [>! <! go chan]]))


(println "Hello," "World")

(say-hello "CodeMania") ; FAIL

(defn say-hello [name]
  (println "Hello," name))

(say-hello "CodeMania Again")

(#(println "Hello," %) "all")


["Orange" "Apple" "Microsoft" 1]

{1 "Monday" 2 "Tuesday" 3 "Wednesday" 4 "Thursday" 5 "Friday" "6" "Saturday" :7 "Sunday"}

#{"Pen" "Apple" "Apple Pen"}

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;




(def x {:a 1 :b 2})
x

(get x :a)
(assoc x :c 3)

(def y {:a {:b {:c {:d 5}}}})
y

(get-in y [:a :b :c :d])
(assoc-in y [:a :b :c :d] 6)
(update-in y [:a :b :c :d] inc)

;y[:a][:b][:c][:d] += 1

(update-in y [:a :b :c :d] #(+ % 1))


(partition-all 4 (range 18))

(filter even? (range 20))

(group-by :name [{:name "David" :age 36}
                 {:name "Michael" :age 40}
                 {:name "David" :age 25}])

(#{3 8 6} 6)

(#{3 8 6} 5)

(filter #{3 8 6} (range 7))


(filter (comp #{3 8 6} :id)
        [{:id 2 :name "Adam"}
         {:id 3 :name "Albert"}
         {:id 4 :name "Alex"}])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;





(doto (java.util.HashMap.)
  (.put "A" 1)
  (.put "B" 2)
  (.put "C" 3))

(let [a 1
      b 2]
  (+ a b))

(pprint
  (macroexpand '(doto (java.util.HashMap.)
                  (.put "A" 1)
                  (.put "B" 2)
                  (.put "C" 3))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;




(def a (atom {:x 1 :y 2}))

a

@a

(assoc @a :x 3)

(swap! a assoc :x 3)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;




(def c (chan))

(go (>! c "Apple"))

(go (println (<! c)))


(go
  (loop []
    (println "In loop:" (<! c))
    (recur)))

(go (>! c "Papaya 2"))



(def c2 (chan 10 (comp
                   (filter (every-pred pos? even?))
                   (map inc))))

(go
  (doseq [n (range -5 5)]
    (>! c2 n)))

(go (println (<! c2)))

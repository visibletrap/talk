(ns demo.core
  (:import (java.util ArrayList)))



(Thread/currentThread)
(Thread/currentThread)
(future (println (Thread/currentThread)))
(conj [1 2 3] 4)
(range 0 10)
(doseq [n (range 1 10)]
  (println n))

















;;;;;;;;; Demo 1 - Race condition ;;;;;;;;;;;;

(def a (ArrayList.))

(do
  (future (doseq [i (range 1 100001)]
            (.add a i)))
  (future (doseq [i (range 100001 200001)]
            (.add a i))))

(count a)
















;;;;;;;;;; Demo 2 - Thread safe ;;;;;;;;;;;;;;;

(def b (atom []))
(do
  (future (doseq [i (range 1 100001)]
            (swap! b conj i)))
  (future (doseq [i (range 100001 200001)]
            (swap! b conj i))))
(count @b)



















;;;;;;;; Demo 3 - Execution count ;;;;;;;;;;;;;

(def run-count (atom 0))
(defn myconj [& args]
  (swap! run-count inc)
  (apply conj args))

(def c (atom []))
(do
  (future (doseq [i (range 0 100000)]
            (swap! c myconj i)))
  (future (doseq [i (range 100000 200000)]
            (swap! c myconj i))))
(count @c)
@run-count




















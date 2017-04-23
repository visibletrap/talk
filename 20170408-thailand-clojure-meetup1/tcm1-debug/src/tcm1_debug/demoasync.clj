(ns tcm1-debug.demoasync
  (:require [clojure.core.async :as a :refer [chan pipeline-blocking to-chan]]))

(comment
  (def x (a/chan (a/sli-buffer 6) (comp (map #(+ 2 %)) (filter even?))))

  (a/go (println "hello" (a/<! x)))

  (a/go (a/>! x 2))

  (let [concurrent 10
        outp disp ut-chan (chan)
        input-coll (range 0 1000)]
    (pipeline-blocking concurrent
                       output-chan
                       (comp (map #(+ 2 %)) (filter even?))
                       (to-chan input-coll))
    (a/<!! (a/into [] output-chan)))

  #_`(let [in (a/to-chan (vec (range 200)))
        out (a/chan)]
    (a/pipeline 5 out (comp (map #(+ 2 %)) (filter even?)) in)
    ()
    (a/close! out)
    (println "hey" (a/<!! (a/into [] out))))
  )





(comp #(+ % 1) #(+ % 6))


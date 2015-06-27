# Clojure Training Outline
1. [Clojure By Example](http://kimh.github.io/clojure-by-example/)
2. [Cognitect Clojure Lab](https://github.com/cognitect/clojure-lab)
3. [CLOJURE for the BRAVE and TRUE](http://www.braveclojure.com)


* Setup REPL
  * [REPL](https://github.com/cognitect/clojure-lab/blob/master/src/cljlab/syntax.clj#L192)
    * (doc)
    * [*1, *2](https://github.com/cognitect/clojure-lab/blob/master/src/cljlab/syntax.clj#L204)
  * Cursive
* LISP
  * (println)
* Paredit
* Function
  * multi-arity
  * variadic
  * Anonymous Function
    * #()
      * [%1, %2, %&](https://github.com/cognitect/clojure-lab/blob/master/src/cljlab/functions.clj#L170)
* [Let](http://kimh.github.io/clojure-by-example/#let)
  * show macro
* [apply](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/functions.clj#L217-L220)
* If
  * do
* Boolean (Truthy)
* Collections
* [Standard libs](http://kimh.github.io/clojure-by-example/#lists)
* Laziness
* Concurrency
  * Future
  * Delay
  * Promise
  * Atom
  * Agent
* [Java Interop](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/functions.clj#L310-L316),[2](http://www.braveclojure.com/java/#3_2__Creating_and_Mutating_Instances)
    * gen uuid
* [recur](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/flowcontrol.clj#L270)
* [core.async](http://www.braveclojure.com/core-async/)
* [Advance standard libs](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/sequences.clj)


## ??
* [require](https://github.com/cognitect/clojure-lab/blob/master/src/cljlab/syntax.clj#L215)
* [function exercises](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/functions.clj#L334)
* [collection exercises](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/unordered-collections.clj#L471)
* [flow control exercises](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/flowcontrol.clj#L347)
* [namespaces](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/namespaces.clj)
* [polymorphism](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/polymorphism.clj)
  * [opinions](https://github.com/cognitect/clojure-lab/blob/b8fe8b7005e3491d392480961a7f1844a3490373/src/cljlab/polymorphism.clj#L16)

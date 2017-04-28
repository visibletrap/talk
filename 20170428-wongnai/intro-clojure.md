# [fit] Clojure

^
Prepare
* Open wongnai project with 3 repl sessions
  * intro
  * cljs
  * Webserver
* Open demoapp project
  * react native

---

# Me

 * Tap
 * More of backend guy. First involved frontend work with ClojureScript
 * Java -> Ruby -> Ruby + Clojure
 * [@visibletrap](https://twitter.com/visibletrap)
 * [Clojure in Thai](https://www.facebook.com/groups/clojurethai/)
 * 2009 - started working professionally
 * 2012 - started playing with Clojure
 * 2015 - started using Clojure professionally

---

# Clojure

 * General purpose programming language
 * Hosted language (with good interop)
  * JVM (Clojure, 2007)
  * JavaScript (ClojureScript, 2011)
  * some others
 * Functional, Lisp, data-oriented

^ We'll learn about these today

---
<br>
<br>
<br>


```Clojure
(println "Hello," "World")
```

^
 * Some basic
 * Lisp - paren in front
 * first position is what to do
 * The rest are arguments
 * not many more
 * Not that hard to get used to it (few hours up to 2 weeks)
 * Don't need to count parens. There's editor plugins to help keeping balance

---

# Data structures

Vector

```clojure
["Orange" "Apple" "Microsoft"]
```

List

```clojure
("dog" "cat" "rat")
```

^
* comma is optional
* index access vs linked list

---

# Data structures

Map

```clojure
{1 "Monday" 2 "Tuesday" 3 "Wednesday" 4 "Thursday"
 5 "Friday" "6" "Saturday" :7 "Sunday"}
```

Set

```clojure
#{"Pen" "Apple" "Apple Pen"}
```

^
* All data structures can contains different types of element
* key/value
* unique

---

# Persistent data structures

* Immutable
* Structural sharing
* Fast
* They are values. Similar to  int, string
* Can drop down to use transient data strucutre for performance

^
* If you ever give your data to other people's function and it's modified. No more problem like that
* No more shallow copy problem
* Equal is easy
* Simpler concurrency

---

# Function
<br>

```Clojure
(defn say-hello [name]
  (println "Hello," name))
```

^
* Point to `defn` and `println`
* Clojure code constructs from data structures
* No more new syntax
* Only new library
* Stable
* That's all you need to know about the syntax

---

# Interactive development with REPL

* Use it for everything
  * Run snippet of code
  * Run test
  * Debug
  * Start server
  * Connectable to browser / mobile devices
* Feedback is the key
* Lower friction trying out a snippet of code
* Debugging on production!!!

^
* Agile, Startup, Product development, TDD, CI, CD, beta app, feedback ร้านอาหาร
* How do you play with a piece of code?
* Switch to IDE

---

# Data modeling

* Use maps
* Reuse tons of collection functions
* Easy to serialize
 * JSON
* Easy to debug

^ Why do we like JSON? Why it's popular?

---

![inline 70%](servlet.png)[^.]

[^.]: Clojure, Made simple https://www.youtube.com/watch?v=VSdnJDO-xdg

---

![inline 70%](ring.png)[^.]

[^.]: Clojure, Made simple https://www.youtube.com/watch?v=VSdnJDO-xdg

---

# How do we sum these?

```clojure
[{:item1 1 :item2 2} {:item1 3 :item3 5} ...]
```

expect

```clojure
{:item1 x :item2 y :item3 z}
```

^ Let people think and switch to IDE

---

# Data modeling

* There are tons of function like `merge-with` and `diff` ready for use
* Official ones are all in [Clojure Cheatsheet](https://clojure.org/api/cheatsheet)
* Practice at https://www.4clojure.com/

---

# Encourage pure functions, minimize side effects

 * There's no purity enforcement

^
* FP thought
* Who know what's pure functions & side effects?

---

# Example of side effects

* Read / Write from to I/O (file, database, http)
* Print to console
* Input from keyboard. Button click
* Setter method

---

# Separate side effects - ideas

* ETL job
* Form validations
* REST

---

# Separate side effects - benefits

* Easy to develop
  * Refactor
* Enable reuse
* Easy to play with the code
  * Setup
  * Confident
* Easy to test
* Easy to change
* Functional core, imperative shell
 * Boundaries - Gary Bernhardt

^ You can't reuse your OO code because the state

---

# Identity, state, value

* Atom for state

^ ปีที่แล้วนาย ก. สูง 164 หนัก 61 ตอนนี้นาย ก. สูง 165 หนัก 60
identity คือ นาย ก.
value ขอมองว่ามี 2 value ก่อนคือ สูง 164 หนัก 61 และสูง 165 หนัก 60
state ถ้าเรามองที่เวลาปัจจุบัน คือ สูง 165 หนัก 60
Switch to IDE

---

# Why does it useful?

* Separate current vs facts
 * Easy to keep track changes overtime
  * Report
  * Undo
* Thread-safe

^Value could be changed while calculating BMI

---

# Macro

* Extend language
* when
* time
* doto

^ Lisp


^ Switch to IDE

---

# Why Macro?

* Small & stable core
* Build your own new feature without waiting for language owner
  * Goroutine & Channels as a library

---

# Webserver

^ IDE

---

# ClojureScript

* Google Closure Compiler and Libraries
 * Dead-code elimination
* With help of React.js
 * f(HTML) = DOM
* I think it's easier than React

^ * The first time that a backend guy feels comfortable on frontend
* React is so functional
* Switch to IDE & start figwheel repl

---

# ClojureScript

* Popular library are provided via [cljsjs](http://cljsjs.github.io/) project
* Aiming for access to all NPM libraries
* Sometimes faster than React
 * Inspiration of Immutable.js

---

# ClojureScript + React Native

---

# Many mores!

* Property based testing (Generative testing)
* Sharing code between Cloure and ClojureScript and others
 * Same code for server & client rendering
 * Sync algorithm
* clojure.spec
* Datomic
 * Database as a value
 * Never forget

---

# What to expect

* Can't program in the same way
 * Can't mutate
* Hard to read in the beginning
* Bad error message
* Slow start REPL
 * Don't need to restart often
* Learn host platform
* Less documentations
 * Do ask on FB group!

---

# Conclusion

* Functional
* Lisp
* Data-oriented
* Reaches
* Again, FB: Clojure in Thai

^
* Event you don't get to use Clojure, can adapt to your language
 * FP - data transformation, side effects, react's fp
* Leverage host platform library

---
# Thank you
# Questions?

---

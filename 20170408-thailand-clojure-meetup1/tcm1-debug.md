# How to debug Clojure app, especially on production

---

# Disclaimer

 * Be careful, it can bring your production down, destroy your data or send messed up stuffs to your users
 * Require enough understanding about Clojure source code loading
 * Just try to demonstrate the possibilities

---

# What do you do when your app is behaving wrongly, and you can't figure out why?

^ Expect answers like
"loading data backup and start local server with that"
"Add println on production for scripting language (PHP, JS)"

---

# Problem with those approaches

 * Have to look in a tons of printing
 * Harder for compiled binary

---

First approach I use usually do, starting a repl on server
 * Just like Rails console
 * Demo

---

Second approach, connect a repl to running process
 * Demo

---

# Pros & Cons
 * Change are discarded after repl session is terminated
 * Observe internal state
 * Modify code on the fly without redeploy

---

Deep Space 1 mission
![inline 80%](deep-space-1.png)
[https://en.wikipedia.org/wiki/Deep_Space_1#Remote_Agent](https://en.wikipedia.org/wiki/Deep_Space_1#Remote_Agent)

---

> With Great Power Comes Great Responsibility
-- Benjamin Parker

^ Would you rather have someone else limiting your power or taking responsibility and control it yourselves


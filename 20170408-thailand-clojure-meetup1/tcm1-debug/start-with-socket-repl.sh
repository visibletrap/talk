#!/usr/bin/env bash

java -Dclojure.server.repl='{:address "0.0.0.0" :port 13456 :accept clojure.core.server/repl}' -jar target/tcm1-debug-0.1.0-SNAPSHOT-standalone.jar

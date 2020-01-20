(defproject hexawise/strokes "0.6.0-alpha1"
  :description "strokes: d3 from clojurescript"
  :url "https://github.com/Hexawise/strokes"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.597"]
                 [hexawise/mrhyde "0.6.0-alpha1"]]
  :min-lein-version "2.9.1"
  :source-paths ["src/cljs"]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                        :jar true}

                       ; tests
                       {:source-paths ["src/cljs" "test/cljs"]
                        :compiler  {:optimizations :whitespace
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/strokes_test_whitespace.js"}}
                       {:source-paths ["src/cljs" "test/cljs"]
                        :compiler  {:optimizations :simple
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/strokes_test_simple.js"}}
                       {:source-paths ["src/cljs" "test/cljs"]
                        :compiler  {:optimizations :advanced
                                    :externs ["public/d3/d3-externs.js"]
                                    :pretty-print true
                                    :print-input-delimiter true
                                    :output-to "public/out/strokes_test_advanced.js"}}


                      ; strokes "internal" examples
                       {:source-paths ["examples/strokes/clocky"]
                        :compiler  {:optimizations :simple
                                    :pretty-print false
                                    :output-to "public/out/strokes-clocky.js"}}
                       {:source-paths ["examples/strokes/hull"]
                        :compiler  {:optimizations :advanced
                                    :externs ["public/d3/d3-externs.js"]
                                    :pretty-print false
                                    :output-to "public/out/strokes-hull.js"}}
                       {:source-paths ["examples/strokes/quadtree"]
                        :compiler  {:optimizations :simple
                                    :pretty-print false
                                    :output-to "public/out/strokes-quadtree.js"}}
                       {:source-paths ["examples/strokes/circle-pack"]
                        :compiler  {:optimizations :simple
                                    :pretty-print false
                                    :output-to "public/out/strokes-circle-pack.js"}}
                      ]})

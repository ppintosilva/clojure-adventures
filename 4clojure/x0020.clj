; #20
; Write a runction which returns the
; second to last element from a sequence.
(require 'clojure.test)

(def f
  (fn [s]
      (let [l (count s)]
           (nth s (- l 2)))))

; tests
(clojure.test/is (= (f [1 2 3 4 5]) 4))

(clojure.test/is (= (f ["a" "b" "c"]) "b"))

(clojure.test/is (= (f [[1 2] [3 4]]) [1 2]))

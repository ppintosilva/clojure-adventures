; #19
; Write a runction which returns the last element of a sequence
; Restrictions: can't use function last
(require 'clojure.test)

(def f
  (fn [s]
      (let [l (count s)]
           (nth s (- l 1)))))

; tests
(clojure.test/is (= (f [1 2 3 4 5]) 5))

(clojure.test/is (= (f '(5 4 3)) 3))

(clojure.test/is (= (f ["b" "c" "d"]) "d"))

; #25
; Write a function which returns only the odd numbers from a sequence.
; -

(use 'clojure.test)

(def g
  (fn [x] (filter odd? x))
)


; tests
(is (= (g #{1 2 3 4 5}) '(1 3 5)))

(is (= (g [4 2 1 6]) '(1)))

(is (= (g [2 2 4 6]) '()))

(is (= (g [1 1 1 3]) '(1 1 1 3)))

; implementing odd myself

(def g2
  (fn [x] (filter  #(= 1 (mod % 2)) x))
)

(is (= (g2 #{1 2 3 4 5}) '(1 3 5)))

(is (= (g2 [4 2 1 6]) '(1)))

(is (= (g2 [2 2 4 6]) '()))

(is (= (g2 [1 1 1 3]) '(1 1 1 3)))

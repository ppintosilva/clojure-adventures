; #21
; Write a runction which returns the
; nth element from a sequence.
; -
; Restrictions: nth

(use 'clojure.test)

(def f
  (fn [s x]
      (let [y (drop x s)]
           (first y)))
)


; tests
(is (= (f '(4 5 6 7) 2) 6))

(is (= (f [:a :b :c] 0) :a))

(is (= (f [1 2 3 4] 1) 2))

(is (= (f '([1 2] [3 4] [5 6]) 2) [5 6]))

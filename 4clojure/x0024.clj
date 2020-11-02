; #24
; Write a function which returns the sum of a sequence of numbers
; -

(use 'clojure.test)

(def my-sum
  (fn [x] (reduce + x))
)



; tests
(is (= (my-sum [1 2 3]) 6))

(is (= (my-sum (list 0 -2 5 5)) 8))

(is (= (my-sum #{4 2 1}) 7))

(is (= (my-sum '(0 0 -1)) -1))

(is (= (my-sum '(1 10 3)) 14))

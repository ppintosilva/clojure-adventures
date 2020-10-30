; #22
; Write a runction which returns the
; total number of elements in a sequence.
; -
; Restrictions: count

(use 'clojure.test)

(def my-count
  (fn [s]
      (loop [xs s
             i 0]
        (if xs (recur (next xs)
                      (inc i))
                i)))
)



; tests
(is (= (my-count '(1 2 3 3 1)) 5))

(is (= (my-count "Hello World") 11))

(is (= (my-count [[1 2] [3 4] [5 6]]) 3))

(is (= (my-count '(13)) 1))

(is (= (my-count '(:a :b :c)) 3))

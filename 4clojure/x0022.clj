; #22
; Write a runction which returns the
; total number of elements in a sequence.
; -
; Restrictions: count

(require 'clojure.test)

(def f
  (fn [s]
      (loop [xs s
             i 0]
        (if xs (recur (next xs)
                      (inc i))
                i)))
)



; tests
(clojure.test/is (= (f '(4 5 6 7) 2) 6))

(clojure.test/is (= (f [:a :b :c] 0) :a))

(clojure.test/is (= (f [1 2 3 4] 1) 2))

(clojure.test/is (= (f '([1 2] [3 4] [5 6]) 2) [5 6]))

(prn "Well done! :)")

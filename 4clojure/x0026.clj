; #26
; Write a function which returns the first X fibonacci numbers.
; -

(use 'clojure.test)

(def fib
  (fn [n]
    (loop [v [1 1]]
      (let [x (+ (last v)
                 (nth v (- (count v) 2)))]
        (if (= (count v) n)
          v
        (recur (conj v x))
)))))

; tests
(is (= (fib 3) '(1 1 2)))

(is (= (fib 6) '(1 1 2 3 5 8)))

(is (= (fib 8) '(1 1 2 3 5 8 13 21)))

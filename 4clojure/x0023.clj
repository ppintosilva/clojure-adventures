; #23
; Write a function which reverses a sequence.
; -

(use 'clojure.test)

(def rev
  (fn [n] ()
))

; tests
(is (= (rev [1 2 3 4 5]) [5 4 3 2 1]))

(is (= (rev (sorted-set 5 7 2 7)) '(7 5 2)))

(is (= (rev [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))

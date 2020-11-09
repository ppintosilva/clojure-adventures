; #32
;'Difficulty:	Easy
;Topics:	seqs


; Write a function which duplicates each element of a sequence.
; -

(use 'clojure.test)

(def duplicate
  (fn [sq] (interleave sq sq)
))

; tests
(is (= (duplicate [1 2 3]) '(1 1 2 2 3 3)))

(is (= (duplicate [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))

(is (= (duplicate [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))

; #33
;'Difficulty:	Easy
;Topics:	seqs

; Write a function which packs consecutive duplicates into sub-lists.
; -

(use 'clojure.test)

(def pack (fn
  [sq]

))

; tests
(is (= (pack [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))

(is (= (pack [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))

(is (= (pack [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))

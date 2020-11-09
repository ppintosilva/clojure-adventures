; #33
;'Difficulty:	Easy
;Topics:	seqs


; Write a function which replicates each element of a sequence a variable
; number of times.
; -

(use 'clojure.test)

(def duplicate-n
  (fn [sq n] (apply interleave (repeat n sq))))

(def duplicate-n-b
  (fn [sq n] (lazy-seq (let [nsq (repeat n sq)] (apply interleave nsq))))

; tests
(is (= (duplicate-n [1 2 3] 2) '(1 1 2 2 3 3)))

(is (= (duplicate-n [:a :b] 4) '(:a :a :a :a :b :b :b :b)))

(is (= (duplicate-n [4 5 6] 1) '(4 5 6)))

(is (= (duplicate-n [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))

(is (= (duplicate-n [44 33] 2) [44 44 33 33]))

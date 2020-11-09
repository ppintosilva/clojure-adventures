; #83 - A Half Truth

; Difficulty:	Easy
; Topics:

; Write a function which takes a variable number of booleans. Your function
; should return true if some of the parameters are true, but not all of the
; parameters are true. Otherwise your function should return false.
; -

(use 'clojure.test)

(def half-truth
  (fn [& lgcs]
    (and (some? (some true? lgcs))
         (not (every? true? lgcs)))))

; tests
(is (= false (half-truth false false)))

(is (= true (half-truth true false)))

(is (= false (half-truth true)))

(is (= true (half-truth false true false)))

(is (= false (half-truth true true true)))

(is (= true (half-truth true true true false)))

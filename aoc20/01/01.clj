; AOC problem 1
; 
; Specifically, they need you to find the two entries that sum to 2020 and then
; multiply those two numbers together.
;
; For example, suppose your expense report contained the following:
;
; 1721
; 979
; 366
; 299
; 675
; 1456
;
; In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying
; them together produces 1721 * 299 = 514579, so the correct answer is 514579.

(defn parse-int [s]
  (Integer. (re-find  #"\d+" s )))

(def input 
  (map parse-int
    (let [s (slurp "input.txt")] (clojure.string/split-lines s))))

; find numbers that solve problem #1
(defn find-expense-2d [ls]
  (first 
    (for [x1 ls x2 ls :when (= (+ x1 x2) 2020)] 
          [x1 x2])))

; find numbers that solve problem #2
(defn find-expense-3d [ls]
  (first 
    (for [x1 ls x2 ls x3 ls :when (= (+ x1 x2 x3) 2020)]
         [x1 x2 x3])))

; could improve the solution by:
; ------------------------------
; writing a function that generalises to n dimensions using a for-comprehension

; results
(def set1 (find-expense-2d input))
(println set1)
(println (reduce * set1))

(def set2 (find-expense-3d input))
(println set2)
(println (reduce * set2))
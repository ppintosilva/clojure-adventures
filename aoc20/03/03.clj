; AOC 2020 problem 3
; ---

(use 'clojure.test)
(require '[clojure.string :as str])

; get the nth number of a sequence that repeats itself infinitely
(defn nth-inf [sq i]
  (nth sq 
      (let [n (count sq)]
           (- i (* (quot i n) n)))))

(defn is-tree [c] (= c \#))

(defn positions [sq] (map #(* % 3) (take (count sq) (range))))

(defn get-path [terrain]
  (map #(nth-inf %1 %2) terrain (positions terrain)))

(defn count-trees [path]
  (count (filter identity (map is-tree path))))


; some tests to check if nth-inf works as expected
(is (= (nth-inf [1 2 3 3 1] 4) 1))
(is (= (nth-inf [1 2 3 3 1] 5) 1))
(is (= (nth-inf [1 2 3 3 1] 6) 2))
(is (= (nth-inf [1 2 3 3 1] 200) 1))
(is (= (nth-inf [1 2 3 3 1] 201) 2))
(is (= (nth-inf [1 2 3 3 1] 202) 3))
(is (= (nth-inf (take 10 (range)) 9) 9))
(is (= (nth-inf (take 10 (range)) 10) 0))
(is (= (nth-inf (take 10 (range)) 20) 0))
(is (= (nth-inf (take 10 (range)) 21) 1))
(is (= (nth-inf (take 10 (range)) 31) 1))
(is (= (nth-inf (take 10 (range)) 101) 1))
(is (= (nth-inf (take 10 (range)) 102) 2))
(is (= (nth-inf (take 10 (range)) 103) 3))

; test input
(def test-input
  (let [s (slurp "test.txt")]
       (str/split-lines s)))

(is (= (count-trees (get-path test-input)) 7))

; ---

(def input 
  (let [s (slurp "input.txt")]
       (str/split-lines s)))

; solution to problem 1
(println (count-trees (get-path input)))

; lazy implementation ; copy pasta sadface
(defn positions-1 [sq] (take (count sq) (range)))
(defn positions-2 [sq] (map #(* % 3) (take (count sq) (range))))
(defn positions-3 [sq] (map #(* % 5) (take (count sq) (range))))
(defn positions-4 [sq] (map #(* % 7) (take (count sq) (range))))
(defn positions-5 [sq] (take (count sq) (range)))

(defn get-path-strategy [terrain strategy]
  (map #(nth-inf %1 %2) terrain (strategy terrain)))

; check that it works for test input
(is (= 336
  (* 
    (count-trees (get-path-strategy test-input positions-1))
    (count-trees (get-path-strategy test-input positions-2))
    (count-trees (get-path-strategy test-input positions-3))
    (count-trees (get-path-strategy test-input positions-4))
    (count-trees (get-path-strategy (take-nth 2 test-input) positions-5)))))

(println
  (* 
    (count-trees (get-path-strategy input positions-1))
    (count-trees (get-path-strategy input positions-2))
    (count-trees (get-path-strategy input positions-3))
    (count-trees (get-path-strategy input positions-4))
    (count-trees (get-path-strategy (take-nth 2 input) positions-5))))

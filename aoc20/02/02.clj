; AOC problem 2
; ---
; To try to debug the problem, they have created a list (your puzzle input) of
; passwords (according to the corrupted database) and the corporate policy when
; that password was set.
;
; For example, suppose you have the following list:
;
; 1-3 a: abcde
; 1-3 b: cdefg
; 2-9 c: ccccccccc
;
; Each line gives the password policy and then the password. The password policy
; indicates the lowest and highest number of times a given letter must appear for
; the password to be valid. For example, 1-3 a means that the password must 
; contain a at least 1 time and at most 3 times.
;
; In the above example, 2 passwords are valid. The middle password, cdefg, 
; is not, it contains no instances of b, but needs at least 1. The first and 
; third passwords are valid: they contain one a or nine c, both within the limits
; of their respective policies.
;
; How many passwords are valid according to their policies?

(require '[clojure.string :as str])

(defn parse-int [s]
  (Integer. (re-find  #"\d+" s )))

(defn parse-line [line]
  (let [ raw-numbers  (re-find (re-pattern "\\d+-\\d+") line)
         raw-letter   (re-find (re-pattern "[a-z]:")    line)
         pass         (re-find (re-pattern "[a-z]+$")   line)]
      (hash-map :policy-letter (let [[letter & rest] raw-letter] letter)
                :policy-numbers (map parse-int (str/split raw-numbers #"-"))
                ; :policy-numbers (let [ m (re-matcher #"\d+" raw-numbers)] 
                ;                       ([(re-find m) (re-find m)])
                :pass pass)))

; count how many times the policy letter shows up in the password
(defn count-occurrences [entry]
  (count 
    (re-seq (re-pattern (str (:policy-letter entry)))
            (:pass entry))))

; check if we can find policy-pattern in pass
(defn verify-policy [entry]
  (let [policy-count (count-occurrences entry)]
    (<= (first (:policy-numbers entry))
        policy-count
        (last (:policy-numbers entry)))))

(def input 
  (map parse-line
    (let [s (slurp "input.txt")]
         (str/split-lines s))))


; Solution to problem 1
(println
  (count (filter identity (map verify-policy input))))

; ----

; problem 2 policy verification function
(defn verify-updated-policy [entry]
  (let [x1 (nth (:pass entry) (dec (first (:policy-numbers entry))))
        x2 (nth (:pass entry) (dec (last  (:policy-numbers entry))))]
        ; [x1 x2]))
        (count 
          (filter identity            
            [(= x1 (:policy-letter entry)) (= x2 (:policy-letter entry))]))))

; Solution to problem 2
(println
  (count (filter #(= 1 %) (map verify-updated-policy input))))
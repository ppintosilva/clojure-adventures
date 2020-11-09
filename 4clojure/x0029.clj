; #29
; Write a function which takes a string and returns a new string containing
; only the capital letters.
; -

(use 'clojure.test)

(def get-caps
  (fn [s]
    (apply str (re-seq #"[A-Z]+" s))))

; tests
(is (= (get-caps "HeLlO, WoRlD!") "HLOWRD"))

(is (empty? (get-caps "nothing")))

(is (= (get-caps "$#A(*&987Zf") "AZ"))

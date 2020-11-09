; #134

; Difficulty:	Elementary
; Topics:	maps
; Write a function which, given a key and map, returns true iff the
; map contains an entry with that key and its value is nil.
; -

(use 'clojure.test)

(def hasnil
  (fn [k m] (and
            (contains? m k)
            (nil? (m k))
)))

; tests
(is (true?  (hasnil :a {:a nil :b 2})))

(is (false? (hasnil :b {:a nil :b 2})))

(is (false? (hasnil :c {:a nil :b 2})))

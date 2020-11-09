; #102 - intoCamelCase

; Difficulty:	Medium
; Topics:	Strings

; When working with java, you often need to create an object with
; fieldsLikeThis, but you'd rather work with a hashmap that has
; :keys-like-this until it's time to convert. Write a function which takes
; lower-case hyphen-separated strings and converts them to camel-case strings.
; -

(use 'clojure.test)

(def to-camel-case
  (fn [s] (apply str
            (let [words (clojure.string/split s #"-")]
              (conj (map clojure.string/capitalize (rest words))
                    (first words))))))

; tests
(is (= (to-camel-case "something") "something"))

(is (= (to-camel-case "multi-word-key") "multiWordKey"))

(is (= (to-camel-case "leaveMeAlone") "leaveMeAlone"))

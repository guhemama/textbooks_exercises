;; loop/recur
(defn fact-loop [n]
  (loop [current n fact 1]
    (if (= current 1)
      fact
      (recur (dec current) (* fact current)))))

;; map
(defn bigger-than-7 [number]
  (if (> number 7)
    (println number + " is bigger than 7")
    (println number + " is 7 or smaller than 7")))

(defn list-biggers [numbers]
  (map bigger-than-7 numbers))

;; filter
(defn non-zero-values [values]
  (filter pos? values))

;; reduce
(defn fact-reduce [n]
  (let [numbers (range 1 (+ n 1))]
    (reduce * numbers)))

;; "tests"
(fact-loop 5)
(list-biggers [1, 3, 5, 9, 12, 8, 20, 7])
(non-zero-values [1, 2, 0.1, 0.0, 3, 0])
(fact-reduce 5)
(map pprint (.split "clojure-fun" "-"))


;; lists
(def my-list '(1 2 3 4))
(def my-list2 (list 1 2 3 4))

;; add to a list
(conj my-list 5)

;; check if is a list
(list? my-list)


;; vectors
(def the-vector [10 20 30 40])

;; returns nth element
(get the-vector 2)

;; returns nth element, throws exception when not found
(nth the-vector 2)

;; associates a new value at index n and returns a new vector
(assoc the-vector 4 50)

;; vectors are also functions
;; returns nth element of the vector
(the-vector 3)


;; maps
(def the-map {:a 1, :b 2, :c 3})

;; fetch item by key
(the-map :b)

;; adds item to map, returns a new map
(assoc the-map :d 4)

;; removes item from map, returns a new map
(dissoc the-map :a)

(def users {:kile {
              :joined "2009-01-01"
              :summary {
                :average {
                  :monthly 1000
                  :yearly 12000}}}})

;; sets nested map value, and returns a new map
(assoc-in users [:kile :summary :average :monthly] 3000)

;; gets value from nested map
(get-in users [:kile :summary :average :monthly])
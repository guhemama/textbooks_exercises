;; Defining a function
(defn total-cost
  "Calculates the total cost of the items"
  [item-cost number-of-items]
  (* item-cost number-of-items))

;; Without the macro
(def total-cost2 (fn [item-cost number-of-items]
  (* item-cost number-of-items)))

;; Using conditions-map to specify pre and post conditions
;; % -> function return value
(defn item-total [price quantity]
  {:pre [(> price 0) (> quantity 0)]
   :post [(> % 0)]}
  (* price quantity))

;; Receiving a function as argument
(defn basic-item-total [price quantity]
  (* price quantity))

;; Call: (with-line-item-conditions basic-item-total 10 20)
(defn with-line-item-conditions [f price quantity]
  {:pre [(> price 0) (> quantity 0)]
   :post [(> % 1)]}
  (apply f [price quantity]))
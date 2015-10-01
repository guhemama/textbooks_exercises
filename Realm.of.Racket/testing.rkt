#lang racket

(require rackunit)

;; Passes
(check-equal? (add1 5) 6)

;; Fails
(check-equal? (add1 5) 7)

;; Checks for inequality
(check-not-equal? 5 4)

;; Checks the second argument against the predicate
(check-pred string? "foo")

;; Checks if two numbers are in a certain range of each other
(check-= 1 3 2)

;; Checks if #t
(check-true (odd? 71))

;; Checks if #f
(check-false (even? 71))

;; Checks if is not #f
(check-not-false (member 5 '(1 2 5)))
#lang racket

(define (my-len a-list)
    (if (empty? a-list)
        0
        (add1 (my-len (rest a-list)))))

(define (list-sum lst)
  (if (empty? lst)
      0
      (+ (list-sum (rest lst)) (first lst))))
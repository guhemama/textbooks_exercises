#lang racket
;; #t
(and (odd? 5) (odd? 7) (odd? 9))

;; #f
(or (even? 5) (odd? 4))

;; Conditional assignment
(define x 5)
(define is-it-even? #f)
(or (odd? x) (set! is-it-even? #t))
(and (even? x) (set! is-it-even? #t))
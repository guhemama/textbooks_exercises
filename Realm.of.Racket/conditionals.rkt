#lang racket

(if (= (+ 1 2) 3)
    'yup
    'nope)

(if (equal? 'foo 'bar)
    'nein-nein-nein
    'yes-precious!)

(define lulz #t)
(cond [(equal? lulz 7) 'zeh-number]
      [(string? lulz) 'zeh-string]
      [else 'zeh-lulz])
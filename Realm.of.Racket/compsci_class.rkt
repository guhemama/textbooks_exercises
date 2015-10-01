#lang racket

(struct student (name id# dorm))

(define mimi (student 'Mimi 1234 'NewHall))
(define nicole (student 'Nicole 5678 'NewHall))
(define rose (student 'Rose 8765 'NewHall))
(define eric (student 'Eric 4321 'NewHall))

(define in-class (list mimi nicole rose eric))

;; Get the student id from the third person in the list
(student-id# (third in-class))
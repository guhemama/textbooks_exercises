#lang racket

(struct student (name id# dorm))
(struct student-body (freshman sophomores juniors seniors))

(define freshman1 (student 'Joe 1357 'NewHall))

(define all-students
  (student-body (list freshman1 (student 'Mimi 1234 'NewHall))
                (list (student 'Nicole 5678 'NewHall))
                (list (student 'Rose 8765 'NewHall) (student 'Lili 9281 'OldHall))
                empty))

;; Gets the name of the first freshman ('Joe)
(student-name (first (student-body-freshman all-students)))

;; Gets the ID of the second junior (9281)
(student-id# (second (student-body-juniors all-students)))
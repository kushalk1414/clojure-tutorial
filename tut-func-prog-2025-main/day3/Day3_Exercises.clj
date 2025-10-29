(ns day3.intro)

;; Recursion

;; Clojure supports recursion, which is a function calling itself.
;; This is often used for problems that can be broken down into smaller subproblems.

;; Recursion instead of loops

(defn looping-sum [n]
  (if (zero? n)
    0
    (+ n (looping-sum (dec n)))))

(looping-sum 5) ;; Returns 15


;; Tail Recursion

(defn tail-recursive-sum [n acc]
  (if (zero? n)
    acc
    (tail-recursive-sum (dec n) (+ acc n))))

(tail-recursive-sum 5 0) ;; Returns 15

;; Normally we don't want to use recursion

;; Clojure comes with built-in functions that can handle recursion for us.
;; Tip: range is a function that generates a sequence of numbers.
(reduce + (range 1 6)) ;; Returns 15

(map inc '(1 2 3 4 5)) ;; Returns (1 2 3 4 5)

(filter even? '(1 2 3 4 5)) ;; Returns (2 4)

;; The loop and recur constructs can be used, but
;; they are not used much in practice.

;; Exercises:

;; Write a function using reduce that calculates the factorial of a number.

(defn fac [n]
  (if (< n 2) 1
      (reduce * 1 (range 2 (+ n 1)))))
(fac 9)
;; Use the map function to create the first 10 factorials.
(map fac (range 1 11))

;; Write a function that generates the first n Fibonacci numbers.

(defn fibu [n]
  (if (<= n 1) 1
      (+ (fibu (- n 1)) (fibu (- n 2)))))


(fibu 4)
(fibu 1)
(fibu 0)

(map fibu (range 0 9))

;; Reimplement the functions from day 1 and 2 using what you learned today.

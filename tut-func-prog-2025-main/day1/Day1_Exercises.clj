;; Day 1: Introduction & Basics - Clojure Exercises



(ns day1.intro
  (:require
   [clojure.string :as str]))

;; This is the format for expressions in Clojure:
;; An expression is a list that starts with an operator followed by its arguments.
;; (OP ARG1 ARG2 ...)

;; Exercise 1: Simple Expressions
;; Evaluate the following expressions in the REPL
(+ 1 2)
(* 3 4)
(str "Hello, " "world!")

;; Exercise 2: Define Basic Functions
;; Define a function that adds two numbers
(defn add [a b]
  (+ a b))
((add 3 5)) ;; Should return 8

;; You cannot create variables in Clojure like you do in other languages.
;; Instead, you define functions or use `def` to create a global variable.
;; using let to give a name to an expression
(let [sum (+ a b)]
  sum)
;; You can then use the new "variable" in the body of the let
;; This is especially useful for more complex expressions

;; Define a function that returns a greeting for a given name
(defn greet [name]
  (str "Hello, " name "!"))
(greet "Alice") ;; Should return "Hello, Alice!"

;; Exercise 3: Pure vs. Impure Functions
;; Identify which of these functions are pure
(defn pure-example [x]
  (* x 2))

(defn impure-example [x]
  (println x))

;; Conditional expressions in Clojure are written using `if`, `when`, and `cond`.

(if (> 5 3)
  "5 is greater than 3"
  "5 is not greater than 3")

(when (= 5 5)
  "This will print because the condition is true.")

(cond
  (> 1 2) "1 is greater than 2"
  (> 3 2) "3 is greater than 2"
  :else "Neither condition is true")

;; Loops in Clojure are not used as much as in other languages.
;; But you can use `loop` and `recur` for now.

(loop [n 5]
  (if (zero? n)
    "Done"
    (do
      (println n)
      (recur (dec n)))))


;; Exercises:

;; write the following in Clojure:

;; 1 + 2
(+ 1 2)

;; 1 + 2 + 3 + 4 + 5 
(+ 1 2 3 4 5)
;; 5 * 3
(* 5 3)
;; 1 + 2 * 3
(+ 1 (* 2 3))

;; Define a function that returning C = 2 * pi * r
;; You can use Math/PI for the value of pi

(defn circumference [r] "returns circumference of circle"
  (* 2 Math/PI r))

(circumference 2)



;; Implement the pythagorean theorem
;; a^2 + b^2 = c^2
;; You can use Math/sqrt to calculate the square root

(defn pytha [a b] "return value of hypotenuse"
  (Math/sqrt (+ (* a a) (* b b))))

(defn sq [x]
  (Math/pow x 2))
(sq 3)

(defn pytha2 [a b]
  (Math/sqrt (+ (sq a) (sq b))))

(pytha 3 4)
(pytha2 3 4)

;; Implement a function 'is-prime?' that checks if a number is prime.

(defn isPrime [x]
  (cond
    (= x 2) true
    (< x 2) false
    (even? x) false
    :else (loop [n 3]
            (cond
              (> (* n n) x) true
              (= 0 (mod x n)) false
              :else (recur (+ n 2))))))

(isPrime 11)

;; Implement a function 'well-formed?' that checks whether a nested list is well-formed.
;; A well-formed list is one where every opening parenthesis has a corresponding closing parenthesis.
;; For example, (well-formed? "((1 2) (3 (4 5)))" should return true,
;; while (well-formed? "((1 2) (3 (4 5))" should return false.

(require '[clojure.string :as str])

(defn well-formed? [s]
  "Check if string is a single well-formed parenthesis expression"
  (let [chars (seq s)]
    (loop [cs chars
           depth 0]
      (cond
        (empty? cs) (zero? depth)                     ;; end: depth must be 0
        (= depth 0) (if (= (first cs) \()             ;; only allow new parens at top level
                      (recur (rest cs) (inc depth))
                      false)
        :else (let [c (first cs)
                    rest-cs (rest cs)
                    depth' (cond
                             (= c \() (inc depth)
                             (= c \)) (dec depth)
                             :else depth)]
                (if (< depth' 0)
                  false
                  (recur rest-cs depth')))))))


(well-formed? "")
(well-formed? "()")
(well-formed? "((1 2)))")
(well-formed? "(((1 2) (3 (4 5))")
(well-formed? "((1 2) (3 (4 5)))")
(well-formed? "((1 2)) (3 (4 5))") ;; edge case with two well formed lists



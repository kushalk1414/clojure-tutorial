(ns day2.intro)

;; Day 2: Data Structures & Functions - Clojure Exercises

;; Lists and Vectors
;; Arrays in other languages are similar to vectors in Clojure.
;; Lists are linked lists, while vectors are more like arrays.

;; Creating a list
(def my-list '(1 2 3 4 5))
my-list

;; Accessing elements in a list
(first my-list) ;; Returns 1
(rest my-list) ;; Returns (2 3 4 5)

;; Instead of modifying a list, you create a new one
(cons 0 my-list) ;; Returns (0 1 2 3 4 5)

;; You can only add to the front of a list

;; Creating a vector
(def my-vector [1 2 3 4 5])

;; Creating a vector from a list
(into [] my-list) ;; Returns [1 2 3 4 5]

;; Accessing elements in a vector
(get my-vector 0) ;; Returns 1
(nth my-vector 1) ;; Returns 2

;; Instead of modifying a vector, you create a new one
(conj my-vector 6) ;; Returns [1 2 3 4 5 6]

;; Removing an element from a vector
(take 3 my-vector) ;; Returns [1 2 3] as a list!
(drop 2 my-vector) ;; Returns [3 4 5] as a list!

;; combining both
(concat (take 2 my-vector) (drop 3 my-vector)) ;; Returns [1 2 4 5]

;; Maps
;; Maps are key-value pairs, similar to dictionaries in Python or objects in JavaScript.

;; Keywords are often used as keys in maps.
;; They are prefixed with a colon, like :key.

:example-key

;; Keywords can be compared to enumerations in other languages.
;; They are unique and can be used as identifiers.

;; Creating a map
(def my-map {:a 1 :b 2 :c 3})

;; Accessing values in a map
(get my-map :a) ;; Returns 1
(:b my-map) ;; Returns 2

;; Adding a key-value pair to a map
(assoc my-map :d 4) ;; Returns {:a 1, :b 2, :c 3, :d 4}

;; Removing a key-value pair from a map
(dissoc my-map :b) ;; Returns {:a 1, :c 3}

;; These are all the basic data structures you need for now.


;; Functions

;; Functions are first-class citizens in Clojure, meaning they can be passed around like data.

(fn [x]
  (* x 2)) ;; This is an anonymous function that doubles its input

;; Exercises:

;; Familiarize yourself with the data structures

;; Write a function named "my-second" using first and rest that returns the second element of a list.

;; Create a data structure using a map that represents a person with keys :name, :age, and :city.

;; Write functions that give you the name, age and city respectively from the map you created.
;; Call them 'name', 'age', and 'city'.

;; Write a function that takes a name, age, and city as arguments and returns a map with those keys.

;; Why could those functions be useful?

;; Implement a function 'money-change' that takes an amount of money in cents and a vector of coin denominations
;; and returns the minimum number of coins needed to make that amount.
;; For example, (money-change 99 [25 10 5 1]) should return 9 (3 quarters, 2 dimes, and 4 pennies).

;; Implement a function "parse-query-params" that takes a query string (like "name=John&age=30")
;; return {:name "John", :age "30"}.
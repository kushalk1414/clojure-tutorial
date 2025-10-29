(ns day2.intro
  (:require
   [clojure.string :as str]))

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
(defn my-second [l]
  (let [tail (rest l)]
    (first tail)))

(my-second my-list)
;; Create a data structure using a map that represents a person with keys :name, :age, and :city.
(def person {:name "kk", :age 34, :city "quickborn"})
person

;; Write functions that give you the name, age and city respectively from the map you created.
;; Call them 'name', 'age', and 'city'.
(def name
  :name)

(defn age [p]
  (:age p))

(defn city [p]
  (:city p))

(name person)
(:name person)

(age person)
(:age person)

(city person)
(:city person)

;; Write a function that takes a name, age, and city as arguments and returns a map with those keys.

(defn p-maker [n a c]
  {:name n, :age a, :city c})
(p-maker "muhammed-ali" 22 "hamburg")

;; Why could those functions be useful? => constructor?? 
;;oder einfach weiter geben...besser als roh daten

;; Implement a function 'money-change' that takes an amount of money in cents and a vector of coin denominations
;; and returns the minimum number of coins needed to make that amount.
;; For example, (money-change 99 [25 10 5 1]) should return 9 (3 quarters, 2 dimes, and 4 pennies).

(defn money-change [amount l]
  (if (or (< amount 1) (empty? l)) 0
      (let [coin (first l)
            num (quot amount coin)
            remainder (mod amount coin)]
        (+ num (money-change remainder (rest l)))))) ;;recursion hier

(money-change 106 [25 10 5 1])
(money-change 24 [25 10 5 1])


(defn divide-with-coin 
  "receive the accumulator map obj containing the 
   amount to be changed and the num. of coins used 
   until that point replace with rest amount after dividing
   with the coin and add the rest of the coins"
  [amt-coll coin]
  (let [rest-amt (mod (:rest amt-coll) coin)
        num-coins (quot (:rest amt-coll) coin)]
   {:rest rest-amt :m (+ num-coins(:m amt-coll))}))

(defn money-change-3 [amt coins]
  (if (or (< amt 1) (empty? coins)) 0
      (reduce divide-with-coin {:m 0, :rest amt} coins)))

(divide-with-coin {:m 0 :rest 99} 25)
(money-change-3 99 [25 10 5 1])


;; Implement a function "parse-query-params" that takes a query string (like "name=John&age=30")
;; return {:name "John", :age "30"}.

(defn parse-query-params [s];;("name=John&age=30")
  (->> (str/split s #"&") ;;["name=John" "age=30"]
       (map #(str/split % #"=")) ;;[["name" "john"] ["age" "30"]]
       (map (fn [[k v]] [(keyword k) v])) 
       (into {}))) ;;


(parse-query-params "name=John&age=30")

(defn param-adder 
  "receive the map where params need to be 
   saved and key val pair and add it to the accumulator map"
  [acc [k v]]
  (assoc acc (keyword k) v)
  )

(defn parse-query-params-reduce [s]
  (let [params (->> (str/split s #"&")      ;; ["name=John" "age=30"]
                    (map #(str/split % #"=")))]
    (reduce param-adder {} params)))


(param-adder {} ["name" "john"])
(parse-query-params-reduce "name=John&age=30")
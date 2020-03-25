(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))


(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))


(defn blank? [string]
  (every? whitespace? string))


(defn has-award? [book award]
   (if (contains? (:awards book) award) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award-check? (fn [x] (has-award? book x))]
    (every? award-check? awards)))

(defn my-some [pred a-seq]
  (if (> (count (filter pred a-seq)) 0) (first (map pred (filter pred a-seq))) false))


(defn my-every? [pred a-seq]
  (if (empty? a-seq) true (apply = (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
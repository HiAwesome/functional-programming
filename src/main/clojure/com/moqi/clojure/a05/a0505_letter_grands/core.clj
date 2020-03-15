(ns com.moqi.clojure.a05.a0505_letter_grands.core
  (:use clojure.test))

(defn in [score low high]
  (and (number? score) (<= low score high)))

; 成绩分等的 Clojure 实现
(defn letter-grade [score]
  (cond
    (in score 90 100) "A"
    (in score 80 90)  "B"
    (in score 70 80)  "C"
    (in score 60 70)  "D"
    (in score 0 60)   "F"
    (re-find #"[ABCDFabcdf]" score) (.toUpperCase score)))

; 测试 letter-grade 方法
(deftest numeric-letter-grades
         (dorun (map #(is (= "A" (letter-grade %))) (range 90 100)))
         (dorun (map #(is (= "B" (letter-grade %))) (range 80 89)))
         (dorun (map #(is (= "C" (letter-grade %))) (range 70 79)))
         (dorun (map #(is (= "D" (letter-grade %))) (range 60 69)))
         (dorun (map #(is (= "F" (letter-grade %))) (range 0 59))))

(deftest string-letter-grades
         (dorun (map #(is (= (.toUpperCase %)
                             (letter-grade %))) ["A" "B" "C" "D" "F" "a" "b" "c" "d" "f"])))

(run-all-tests)


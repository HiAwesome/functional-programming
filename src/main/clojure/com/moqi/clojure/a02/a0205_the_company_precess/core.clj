(ns com.moqi.clojure.a02.a0205_the_company_precess.core
  (:require [clojure.string :as s]))

; 通过 Clojure 实现 Process 过程
; BEGIN clj_process
(defn process [list-of-employees]
  (reduce str (interpose ","
                         (map s/capitalize (filter #(< 1 (count %)) list-of-employees)))))
; END clj_process


; 通过 Thread-last 宏改善代码的可读性
; BEGIN clj_process_thread
(defn process2 [list-of-employees]
  (->> list-of-employees
       (filter #(< 1 (count %)))
       (map s/capitalize)
       (interpose ",")
       (reduce str)))
; END clj_process_thread

;; Smith,Moqi,Tom,Jack
(def a_list (list "smith" "moqi" "tom" "jack"))
(println (process2 a_list))

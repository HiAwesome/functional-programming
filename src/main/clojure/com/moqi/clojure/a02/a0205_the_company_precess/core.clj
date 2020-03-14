(ns com.moqi.clojure.a02.a0205_the_company_precess.core
  (:require [clojure.string :as s])
  )

; BEGIN clj_process
(defn process [list-of-employees]
  (reduce str (interpose ","
                         (map s/capitalize (filter #(< 1 (count %)) list-of-employees)))))
; END clj_process

; BEGIN clj_process_thread
(defn process2 [list-of-employees]
  (->> list-of-employees
       (filter #(< 1 (count %)))
       (map s/capitalize)
       (interpose ",")
       (reduce str)))
; END clj_process_thread

;; Abcd,Moqi,Tom,Jack
(println (process2 (list "abcd" "moqi" "tom" "jack")))
;(println (process2 (data1/employee-list)))
(ns com.moqi.clojure.a05.a0507_color_dispatch.core
  (:require [clojure.test :refer :all]))

; 用 Clojure 定义一个表示色彩的数据结构
;BEGIN clj_color
(defstruct color :red :green :blue)

(defn red [v]
  (struct color v 0 0))

(defn green [v]
  (struct color 0 v 0))

(defn blue [v]
  (struct color 0 0 v))
;END clj_color

; 定义一个多重方法
;BEGIN clj_colors_in
(defn basic-colors-in [color]
  (for [[k v] color :when (not= v 0)] k))

(defmulti color-string basic-colors-in)

(defmethod color-string [:red] [color]
  (str "Red: " (:red color)))

(defmethod color-string [:green] [color]
  (str "Green: " (:green color)))

(defmethod color-string [:blue] [color]
  (str "Blue: " (:blue color)))

(defmethod color-string :default [color]
  (str "Red:" (:red color) ", Green: " (:green color) ", Blue: " (:blue color)))

;END clj_colors_in

; 测试 Clojure 版的色彩模型
(deftest pure-colors
  (is (= "Red: 5" (color-string (struct color 5 0 0))))
  (is (= "Green: 12" (color-string (struct color 0 12 0))))
  (is (= "Blue: 40" (color-string (struct color 0 0 40)))))

(deftest varied-colors
  (is (= "Red:5, Green: 40, Blue: 6" (color-string (struct color 5 40 6)))))

(run-all-tests)
# Functional Programming

* 参考书：[函数式编程思维](https://book.douban.com/subject/26587213/) 。

* 函数式编程练习：大多数实现使用 Clojure、Java、Groovy、Scala。 

* 目前 Cursive 未配置正确或有 bug 导致 Clojure 无法直接运行。在确保本机 Clojure 环境正常的情况下，参考 [How can I run a .clj Clojure file I created?](https://stackoverflow.com/a/18525059) 安装 [Leiningen](https://github.com/technomancy/leiningen) 和 [lein-exec](https://github.com/kumarshantanu/lein-exec) , 然后在命令行环境进入脚本目录下（IntelliJ IDEA 可以为此操作设定快捷键，单文件的 Open in Terminal），使用 lein exec core.clj 执行命令。 参考 [Scripting Clojure with Leiningen 2](http://charsequence.blogspot.com/2012/04/scripting-clojure-with-leiningen-2.html) 练习 lein exec 的使用， 参考 [Clojure入门教程](https://wizardforcel.gitbooks.io/clojure-fpftj/content/) 练习基础 Clojure 语法。

* 本项目使用 Maven 管理 Java 依赖。

## 书中片段

* 面向对象编程通过封装不确定因素来使代码能被人理解；函数式编程通过尽量减少不确定因素来使代码能被人理解。  ——Michael Feathers
* 语言设计者实现出来的机制总是比开发者自己做的效率更高，因为他们可以不受语言本身的限制。
* 100 个函数操作一种数据结构的组合，要好过 10 个函数操作 10 种数据结构的组合。  ——Alan Perlis
 
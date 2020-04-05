gradle构建脚本
============
参考资料

https://guides.gradle.org/writing-gradle-tasks/

https://guides.gradle.org/creating-new-gradle-builds/

默认读取 build.gradle 文件

> gradle hello

> gradle -q hello  简化输出

也可以指定构建文件 -b 选项参数

> gradle -b hello.gradle hello

> gradle tasks --all

> gradle test01   group分组参数、description描述参数

> gradle test02   单独采用groovy类构建task

> gradle copy     从 src 目录中把文件拷贝到 dest 目录中

> gradle properties 显示项目属性

解释
===

```groovy
task hello {
    println 'Hello world!'
    println "Project name: ${project.name}"
}
```

参考资料 https://www.jianshu.com/p/e5de9538effa

Project 其中有 getName()

在 hello_01 中 BookBean.groovy 中有示例代码，所以：
project.name 实际调用 project.getName()
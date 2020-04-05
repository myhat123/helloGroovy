> gradle init

```
$ gradle init
Starting a Gradle Daemon (subsequent builds will be faster)

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Swift
Enter selection (default: Java) [1..5] 2

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 1

Project name (default: hello_08): 
Source package (default: hello_08): 

> Task :init
Get more help with your project: https://docs.gradle.org/6.2.2/userguide/tutorial_groovy_projects.html

BUILD SUCCESSFUL in 20s
2 actionable tasks: 2 executed
```

构建jar包
========
> $ gradle build

执行
===
> $ java -cp $GROOVY_HOME/grooid/groovy-2.5.7-grooid.jar:./build/classes/groovy/main hello_08/App

> $ java -cp $GROOVY_HOME/grooid/groovy-2.5.7-grooid.jar:./build/libs/hello_08.jar hello_08.App

单元测试
=======
采用了spock包，模仿例子写了简单的sum(2, 5)测试结果
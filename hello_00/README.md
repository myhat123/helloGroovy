运行groovy
=========

第一种
-----
```
$ groovysh
Groovy Shell (2.5.7, JVM: 1.8.0_211)
Type ':help' or ':h' for help.
-------------------------------------------------------------------------------
groovy:000> "hello world"
===> hello world
groovy:000> "Welcome " + System.properties."user.name"
===> Welcome hzg
```
使用第三方包

libs下包含joda-time

```
$ groovysh -cp ./libs/joda-time-2.10.5.jar:./libs/joda-convert-2.2.1.jar
Groovy Shell (2.5.7, JVM: 1.8.0_211)
Type ':help' or ':h' for help.
------------------------------------------------------------------
groovy:000> import org.joda.time.DateTime
===> org.joda.time.DateTime
groovy:000> def dt = new DateTime()
===> 2020-03-27T20:32:11.423+08:00
groovy:000> dt.getYear()
===> 2020
```

第二种
-----
> $ groovy Hello.groovy

第三种
-----
> $ groovyc -d classes Hello.groovy

对每一个脚本，groovy生成一个类，这个类继承 groovy.lang.Script，这个类会包含一个main方法，java
会执行它。

> $ javap classes/Hello.class

```java
Compiled from "Hello.groovy"
public class Hello extends groovy.lang.Script {
  public static transient boolean __$stMC;
  public Hello();
  public Hello(groovy.lang.Binding);
  public static void main(java.lang.String...);
  public java.lang.Object run();
  public java.lang.Object sum(java.lang.Object, java.lang.Object);
  protected groovy.lang.MetaClass $getStaticMetaClass();
}
```

> java -cp $GROOVY_HOME/grooid/groovy-2.5.7-grooid.jar:classes Hello
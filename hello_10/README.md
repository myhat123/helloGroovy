依赖包
=====

postgresql-42.2.11.jar

groovy-sql-2.5.8.jar

> $ java -cp $GROOVY_HOME/indy/groovy-2.5.7-indy.jar:$GROOVY_HOME/indy/groovy-sql-2.5.7-indy.jar:/home/hzg/work/helloGroovy/hello_10/postgresql-42.2.11.jar::./build/libs/hello_10.jar hello_10.App

增加shadowJar插件

> gradle shadowJar

会把所有需要的包打入hello_10-all.jar

> $ java -jar ./build/libs/hello_10-all.jar

日期类型转换
==========

java.sql.Date, java.util.Date 两者区别不同  
代码中的字符串格式是‘2019-11-28’，在jdbc中是对应 java.sql.Date  

https://www.tutorialspoint.com/jdbc/jdbc-data-types.htm

命令行参数
=========

java社区有多个处理命令行参数的包，如picocli, jcommander等  
groovy 本身自带了 groovy.util.CliBuilder

这是groovy 2.4.7的文档及示例  
http://docs.groovy-lang.org/2.4.7/html/gapi/groovy/util/CliBuilder.html


> $ java -jar ./build/libs/hello_10-all.jar -l

> $ java -jar ./build/libs/hello_10-all.jar -r

resource文件
===========

把data.csv文件放入resources目录中，并打包进入jar中  
http://docs.groovy-lang.org/latest/html/groovy-jdk/java/net/URL.html
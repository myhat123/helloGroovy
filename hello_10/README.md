依赖包
=====

postgresql-42.2.11.jar
groovy-sql-2.5.8.jar

$ java -cp $GROOVY_HOME/indy/groovy-2.5.7-indy.jar:$GROOVY_HOME/indy/groovy-sql-2.5.7-indy.jar:/home/hzg/work/helloGroovy/hello_10/postgresql-42.2.11.jar::./build/libs/hello_10.jar hello_10.App

增加shadowJar插件

gradle shadowJar

会把所有需要的包打入hello_10-all.jar

$ java -jar ./build/libs/hello_10-all.jar
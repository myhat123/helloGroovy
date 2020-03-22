def log = ''
(1..10).each { log += it } //魔幻变量it
assert log == '12345678910'

//变量赋值声明闭包
def printer = {line -> println line}

//方法返回值声明闭包
def Closure getPrinter() {
    return {line -> println line }
}

def pickEven(n, block) {
    for(int i = 2; i <= n; i += 2) {
        block(i)
    }
}
pickEven(10, {println it})

pickEven(10) {println it} //闭包作为最后一个参数

total = 0
pickEven(10) { total += it }
println "Sum of even numbers from 1 to 10 is ${total}"

product = 1
pickEven(10) { product *= it }
println "Product of even numbers from 1 to 10 is ${product}"

def examiningClosure(closure) {
    closure()
}

examiningClosure() {
    println "In First Closure:"
    println "class is " + getClass().name
    println "this is " + this + ", super:" + this.getClass().superclass.name
    println "owner is " + owner + ", super:" + owner.getClass().superclass.name
    println "delegate is " + delegate + ", super:" + delegate.getClass().superclass.name

    examiningClosure() {
        println "In Closure within the First Closure:"
        println "class is " + getClass().name
        println "this is " + this + ", super:" + this.getClass().superclass.name
        println "owner is " + owner + ", super:" + owner.getClass().superclass.name
        println "delegate is " + delegate + ", super:" + delegate.getClass().superclass.name
    }
}
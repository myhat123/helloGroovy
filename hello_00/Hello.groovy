def sum(a, b) {
    return a + b
}

def x = sum(2, 3)
println "Sum-01: ${x}"

x = sum 5, 7 //去除括号调用函数
//println 也是去除了括号调用
println "Sum-02: ${x}"

//字符串 三种方式 单引号、双引号、三双引号
//双引号 GString
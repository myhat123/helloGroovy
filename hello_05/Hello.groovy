class Hello {
    static void main(args) {
        def x = Utils.sum(2, 3)
        println "Sum: ${x}"
    }
}

class Utils {
    static sum(a, b) {
        return a+b
    }
}
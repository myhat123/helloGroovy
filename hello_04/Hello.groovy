class Hello {
    static void main(args) {
        def x = sum(2, 3)
        println "Sum: ${x}"
    }

    static sum(a, b) {
        return a+b
    }
}

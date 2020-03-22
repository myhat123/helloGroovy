assert 1 == 1
def x = 1
assert x == 1
def y = 1; assert y == 1
//assert 1 == 2

assert ('text'*3 << 'hello').size() == 4*3+5

//正则表达式
assert '12345' =~ /\d+/
assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x')

//数字是对象
def a = 1
def b = 2
assert a.plus(b) == 3
assert a instanceof Integer

//列表 list
def c = ['1', '2', '3']
assert c[2] == '3'
c[3] = '4444'
assert c.size() == 4

//map
def http = [ 
    100 : 'CONTINUE', 
    200 : 'OK', 
    400 : 'BAD REQUEST' 
] 
assert http[200] == 'OK' 
http[500] = 'INTERNAL SERVER ERROR' 
assert http.size() == 4 

langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']
assert langs.Java == 'Gosling'
assert langs.'C++' == 'Stroustrup'
println langs.getClass().name

//range
def d = 1..10
assert d.contains(5)
assert d.from == 1
assert d.to == 10
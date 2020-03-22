class Book {
    String title
}

def groovyBook = new Book()

groovyBook.setTitle('Groovy in action')
assert groovyBook.getTitle() == 'Groovy in action'

groovyBook.title = 'Groovy in world'
assert groovyBook.title == 'Groovy in world'
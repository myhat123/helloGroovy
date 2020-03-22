class Book {
    private String title
    Book(String t) {
        title = t
    }
    String getTitle() {
        return title
    }
}

Book gina = new Book('Groovy in Action')
assert gina.getTitle() == 'Groovy in Action'
assert getTitleBackwards(gina) == 'noitcA ni vyoorG'

String getTitleBackwards(book) {
    title = book.getTitle()
    return title.reverse()
}
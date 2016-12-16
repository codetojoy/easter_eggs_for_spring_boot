
interface BookRepository {
    List<Book> findAll()
    void save(Book book)
}

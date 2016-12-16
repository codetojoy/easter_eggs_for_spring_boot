@Repository
class JdbcBookRepository implements BookRepository {

  @Autowired
  JdbcTemplate jdbc

  List<Book> findAll() {
    jdbc.query(
        "select id, title, author from Book",
        { rs, row ->
              new Book(id: rs.getLong(1),
                  title: rs.getString(2),
                  author: rs.getString(3))
        } as RowMapper)
  }

  void save(Book book) {
    jdbc.update("insert into Book " +
                "(title, author) " +
                "values (?, ?)",
        book.title, 
        book.author) 
  }
}

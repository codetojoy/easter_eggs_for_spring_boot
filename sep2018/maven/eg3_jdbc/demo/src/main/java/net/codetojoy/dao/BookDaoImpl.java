package net.codetojoy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import net.codetojoy.model.Book;

@Repository
public class BookDaoImpl extends JdbcDaoSupport implements BookDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    @Override
    public List<Book> getBooks() {
        String sql = "SELECT * FROM books";

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Book> results = new ArrayList<>();

        for (Map<String, Object> row : rows) {
            Integer id = (Integer) row.get("id");
            String author = (String) row.get("author");
            String title = (String) row.get("title");
            Book book = new Book(id, author, title);
            results.add(book);
        }

        return results;
    }
}

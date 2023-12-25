package DAO;

import Entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final String url = "jdbc:mysql://localhost:3306/mock";
    private final String username = "root";
    private final String password = "";

    public void createBookTable() throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "CREATE TABLE IF NOT EXISTS Book (" +
                    "bID INT(10) AUTO_INCREMENT PRIMARY KEY," +
                    "bookName VARCHAR(50) NOT NULL," +
                    "price DOUBLE NOT NULL," +
                    "genre VARCHAR(10)," +
                    "author VARCHAR(13)," +
                    "qty INT(4)," +
                    "status VARCHAR(10)," +
                    "total_page INT(4)" +
                    ")";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.executeUpdate();
            }
        }
    }

    public void save(Book book) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "INSERT INTO Book (bookName, price, genre, author, qty, status, total_page) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, book.getBookName());
                statement.setDouble(2, book.getPrice());
                statement.setString(3, book.getGenre());
                statement.setString(4, book.getAuthor());
                statement.setInt(5, book.getQty());
                statement.setString(6, book.getStatus());
                statement.setInt(7, book.getTotalPage());

                statement.executeUpdate();
            }
        }
    }

    public void update(Book book) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "UPDATE Book SET price = ?, genre = ?, author = ?, qty = ?, status = ?, total_page = ? " +
                    "WHERE bookName = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setDouble(1, book.getPrice());
                statement.setString(2, book.getGenre());
                statement.setString(3, book.getAuthor());
                statement.setInt(4, book.getQty());
                statement.setString(5, book.getStatus());
                statement.setInt(6, book.getTotalPage());
                statement.setString(7, book.getBookName());

                statement.executeUpdate();
            }
        }
    }

    public void remove(String bookName) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "DELETE FROM Book WHERE bookName = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, bookName);

                statement.executeUpdate();
            }
        }
    }

    public List<Book> find(String bookName) throws SQLException {
        List<Book> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Book WHERE bookName = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, bookName);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Book book = new Book();
                        book.setbID(resultSet.getInt("bID"));
                        book.setBookName(resultSet.getString("bookName"));
                        book.setPrice(resultSet.getDouble("price"));
                        book.setGenre(resultSet.getString("genre"));
                        book.setAuthor(resultSet.getString("author"));
                        book.setQty(resultSet.getInt("qty"));
                        book.setStatus(resultSet.getString("status"));
                        book.setTotalPage(resultSet.getInt("total_page"));

                        books.add(book);
                    }
                }
            }
        }

        return books;
    }

    public List<Book> displayAll() throws SQLException {
        List<Book> books = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Book ORDER BY bookName";

            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setbID(resultSet.getInt("bID"));
                    book.setBookName(resultSet.getString("bookName"));
                    book.setPrice(resultSet.getDouble("price"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setQty(resultSet.getInt("qty"));
                    book.setStatus(resultSet.getString("status"));
                    book.setTotalPage(resultSet.getInt("total_page"));

                    books.add(book);
                }
            }
        }
        return books;
    }
}
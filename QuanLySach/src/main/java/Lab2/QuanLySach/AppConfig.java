package Lab2.QuanLySach;

import Lab2.QuanLySach.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class AppConfig {
    @Bean
    public List<Book> getBooks(){
        List<Book> listBooks = new ArrayList<>();

        Book book1 = Book.builder()
                .id(1)
                .title("Clean Code")
                .author("Robert C.Martin")
                .price(47.0)
                .category("Software Engineering").build();
        listBooks.add(book1);
        Book book2 = Book.builder()
                .id(2)
                .title("Desugn Patterns: Elements of Reusable Object-Oriented Software")
                .author("Erich Gamme, Richard Helm, Ralph Johnson, John Vlissides")
                .price(55.0)
                .category("Software Design").build();
        listBooks.add(book2);
        Book book3 = Book.builder()
                .id(3)
                .title("Effective Java")
                .author("Joshua Bloch")
                .price(45.0)
                .category("Programing").build();
        listBooks.add(book3);
        return listBooks;
    }
}

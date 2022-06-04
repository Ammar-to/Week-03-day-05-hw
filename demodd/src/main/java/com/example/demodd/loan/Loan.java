package com.example.demodd.loan;

import com.example.demodd.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Integer bookId;
    @ManyToMany(mappedBy = "loans",cascade = CascadeType.ALL)
    private Set<Book> books;

    public Loan(Object o, Integer id, Integer id1) {
    }
}

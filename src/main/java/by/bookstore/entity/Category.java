package by.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(
        name = "category",
        uniqueConstraints = {
                @UniqueConstraint(name = "category_name_unique", columnNames = "name")
        }
)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "category_id",
            unique = true,
            updatable = false,
            nullable = false
    )
    private Long categoryId;

    @Column(
            name = "name",
            length = 32,
            unique = true,
            nullable = false
    )
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "category"
    )
    private Set<Book> books = new HashSet<>(0);

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }
}

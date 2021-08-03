package by.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "category_id",
            unique = true,
            nullable = false
    )
    private Long categoryId;

    @Column(
            name = "name",
            unique = true,
            nullable = false
    )
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "category"
    )
    private Set<Books> books = new HashSet<>(0);

    public Categories(String name) {
        this.name = name;
    }

    public Categories(String name, Set<Books> books) {
        this.name = name;
        this.books = books;
    }
}

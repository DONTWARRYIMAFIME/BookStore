package by.bookstore.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(
        name = "category",
        uniqueConstraints = {
                @UniqueConstraint(name = "category_name_unique", columnNames = "name")
        }
)
@NamedQueries({
        @NamedQuery(
                name = "Category.findByName",
                query = "SELECT c FROM Category c WHERE c.name = :name"
        )
})
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

    @ToString.Exclude
    private Set<Book> books = new HashSet<>(0);

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Category category = (Category) o;

        return Objects.equals(categoryId, category.categoryId);
    }

    @Override
    public int hashCode() {
        return 1596826009;
    }
}

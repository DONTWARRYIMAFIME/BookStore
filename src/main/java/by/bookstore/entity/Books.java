package by.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(
        name = "books",
        uniqueConstraints = {
                @UniqueConstraint(name = "book_title_unique", columnNames = "title")
        }
)
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "book_id",
            unique = true,
            nullable = false
    )
    private Long bookId;

    @Column(
            name = "title",
            columnDefinition = "TEXT",
            unique = true,
            nullable = false
    )
    private String title;

    @Column(
            name = "author",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String author;

    @Column(
            name = "description",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String description;

    @Column(
            name = "isbn",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String isbn;


    @Column(
            name = "image_url",
            columnDefinition = "TEXT"
    )
    private String imageUrl;

    @Column(
            name = "price",
            columnDefinition = "NUMERIC",
            nullable = false
    )
    private Double price;

    @Column(
            name = "publish_date_time",
            columnDefinition = "DATETIME",
            nullable = false
    )
    private LocalDateTime publishDateTime;

    @Column(
            name = "update_date_time",
            columnDefinition = "DATETIME",
            nullable = false
    )
    private LocalDateTime updateDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private Categories category;

    public Books(String title,
                 String author,
                 String description,
                 String isbn,
                 String imageUrl,
                 Double price,
                 LocalDateTime publishDateTime,
                 LocalDateTime updateDateTime,
                 Categories category) {

        this.title = title;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.imageUrl = imageUrl;
        this.price = price;
        this.publishDateTime = publishDateTime;
        this.updateDateTime = updateDateTime;
        this.category = category;

    }
}

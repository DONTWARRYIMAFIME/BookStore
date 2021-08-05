package by.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "review_id",
            unique = true,
            updatable = false,
            nullable = false
    )
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "book_id",
            nullable = false
    )
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "customer_id",
            nullable = false
    )
    private Customer customer;

    @Column(
            name = "comment",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String comment;

    @Column(
            name = "rating",
            columnDefinition = "NUMERIC",
            nullable = false
    )
    private Float rating;

    @Column(
            name = "review_date_time",
            columnDefinition = "DATETIME",
            nullable = false
    )
    private LocalDateTime reviewDateTime;

    @Column(
            name = "headline",
            length = 128,
            nullable = false
    )
    private String headline;

    public Review(Book book,
                  Customer customer,
                  String comment,
                  Float rating,
                  LocalDateTime reviewDateTime,
                  String headline) {

        this.book = book;
        this.customer = customer;
        this.comment = comment;
        this.rating = rating;
        this.reviewDateTime = reviewDateTime;
        this.headline = headline;

    }
}

package by.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "order_id",
            unique = true,
            updatable = false,
            nullable = false
    )
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "book_id",
            nullable = false
    )
    private Book book;

    @Column(
            name = "quantity",
            nullable = false
    )
    private Integer quantity;

    @Column(
            name = "subtotal",
            columnDefinition = "NUMERIC",
            nullable = false
    )
    private Double subtotal;

}

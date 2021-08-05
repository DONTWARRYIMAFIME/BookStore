package by.bookstore.entity;

import by.bookstore.entity.type.OrderStatus;
import by.bookstore.entity.type.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book_order")
public class BookOrder {

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
            name = "customer_id",
            nullable = false
    )
    private Customer customer;

    @Column(
            name = "order_date_time",
            columnDefinition = "DATETIME",
            nullable = false
    )
    private LocalDateTime orderDateTime;

    @Column(
            name = "order_total",
            columnDefinition = "NUMERIC",
            nullable = false
    )
    private Double orderTotal;

    @Column(
            name = "recipient_full_name",
            length = 97,
            nullable = false
    )
    private String recipientFullName;

    @Column(
            name = "recipient_phone_number",
            length = 24,
            nullable = false
    )
    private String recipientPhoneNumber;

    @Column(
            name = "shipping_address",
            length = 128,
            nullable = false
    )
    private String shippingAddress;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "payment_method",
            nullable = false
    )
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false
    )
    private OrderStatus status;

    public BookOrder(Customer customer,
                     LocalDateTime orderDateTime,
                     Double orderTotal,
                     String recipientFullName,
                     String recipientPhoneNumber,
                     String shippingAddress,
                     PaymentMethod paymentMethod,
                     OrderStatus status) {

        this.customer = customer;
        this.orderDateTime = orderDateTime;
        this.orderTotal = orderTotal;
        this.recipientFullName = recipientFullName;
        this.recipientPhoneNumber = recipientPhoneNumber;
        this.shippingAddress = shippingAddress;
        this.paymentMethod = paymentMethod;
        this.status = status;

    }
}

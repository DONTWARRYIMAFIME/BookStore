package by.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "customer_id",
            unique = true,
            updatable = false,
            nullable = false
    )
    private Long customerId;

    @Column(
            name = "email",
            length = 128,
            nullable = false
    )
    private String email;

    @Column(
            name = "full_name",
            length = 97,
            nullable = false
    )
    private String fullName;

    @Column(
            name = "address",
            length = 128,
            nullable = false
    )
    private String address;

    @Column(
            name = "city",
            length = 32,
            nullable = false
    )
    private String city;

    @Column(
            name = "country",
            length = 64,
            nullable = false
    )
    private String country;

    @Column(
            name = "phone_number",
            length = 24,
            nullable = false
    )
    private String phoneNumber;

    @Column(
            name = "zip_code",
            length = 10,
            nullable = false
    )
    private String zipCode;

    @Column(
            name = "registration_date_time",
            columnDefinition = "DATETIME",
            nullable = false
    )
    private LocalDateTime registrationDateTime = LocalDateTime.now();

    @Column(
            name = "password",
            length = 64,
            nullable = false
    )
    private String password;

    public Customer(String email,
                    String fullName,
                    String address,
                    String city,
                    String country,
                    String phoneNumber,
                    String zipCode,
                    String password) {

        this.email = email;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.password = password;

    }

}

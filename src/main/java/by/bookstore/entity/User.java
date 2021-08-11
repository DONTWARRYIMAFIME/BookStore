package by.bookstore.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "user_email_unique", columnNames = "email")
        }
)
@NamedQueries({
        @NamedQuery(
                name = "User.findAll",
                query = "SELECT u FROM User u ORDER BY u.firstName"
        ),
        @NamedQuery(
                name = "User.count",
                query = "SELECT Count(u) FROM User u"
        )
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "user_id",
            unique = true,
            updatable = false,
            nullable = false
    )
    private Long userId;

    @Email
    @NotEmpty(message = "Email cannot be empty")
    @Column(
            name = "email",
            length = 128,
            unique = true,
            nullable = false
    )
    private String email;

    @NotBlank(message = "First name cannot be empty")
    @Column(
            name = "first_name",
            length = 32,
            nullable = false
    )
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Column(
            name = "last_name",
            length = 64,
            nullable = false
    )
    private String lastName;

    @NotBlank(message = "Phone number cannot be empty")
    @Column(
            name = "phone_number",
            length = 24,
            nullable = false
    )
    private String phoneNumber;

    @NotBlank(message = "Date of birth cannot be empty")
    @Column(
            name = "dob",
            columnDefinition = "DATE",
            nullable = false
    )
    private LocalDate dob;

    @Column(
            name = "image_url",
            columnDefinition = "TEXT"
    )
    private String imageUrl;

    @Column(
            name = "password",
            length = 64,
            nullable = false
    )
    private String password;

    public User(String email,
                String firstName,
                String lastName,
                String phoneNumber,
                LocalDate dob,
                String imageUrl,
                String password) {

        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.imageUrl = imageUrl;
        this.password = password;

    }
}

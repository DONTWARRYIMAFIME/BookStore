package by.bookstore.entity;

import lombok.AllArgsConstructor;
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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "user_id",
            nullable = false,
            updatable = false
    )
    private Long userId;

    @NotBlank(message = "First name cannot be empty")
    @Column(
            name = "first_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Column(
            name = "last_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String lastName;

    @NotBlank(message = "Date of birth cannot be empty")
    @Column(
            name = "dob",
            columnDefinition = "DATE",
            nullable = false
    )
    private LocalDate dob;

    @Email
    @NotEmpty(message = "Email cannot be empty")
    @Column(
            name = "email",
            columnDefinition = "TEXT",
            unique = true,
            nullable = false
    )
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Column(
            name = "phone_number",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String phoneNumber;

    @Column(
            name = "image_url",
            columnDefinition = "TEXT"
    )
    private String imageUrl;

    @Column(
            name = "password",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String password;

    public Users(String firstName, String lastName, LocalDate dob, String email, String phoneNumber, String imageUrl, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.imageUrl = imageUrl;
        this.password = password;
    }
}

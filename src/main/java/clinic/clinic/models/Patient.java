package clinic.clinic.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "NAME IS REQUIRED")
    @Column(name = "name", nullable =false, length = 100)
    private String name;

    @Email(message = "EMAIL IS NOT VALID")
    @NotBlank(message = "EMAIL IS REQUIRED")
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Size(min = 8, message = "PASSWORD TOO SHORT")
    @Column(name = "password", nullable = false, length = 100)
    private String password;

}
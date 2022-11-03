package lpnu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.Status;
import lpnu.entity.enumeration.UserRole;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private String email;
    @JsonIgnore
    private LocalDate birthday;
    private Status status;
    private UserRole role;
}

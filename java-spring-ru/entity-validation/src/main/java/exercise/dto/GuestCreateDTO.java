package exercise.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// BEGIN
@Setter
@Getter
public class GuestCreateDTO {
    @NotNull
    private String name;
    @Email
    private String email;
    @Size(min = 11, max = 13)
    @Pattern(regexp = "^[+][\\d]*")
    private String phoneNumber;
    @Size(min = 4, max = 4)
    @Pattern(regexp = "[\\d]*")
    private String clubCard;
    @Future
    private LocalDate cardValidUntil;
}
// END

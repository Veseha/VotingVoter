package votingvoter.Security.registration;

import votingvoter.Security.user.Role;
import lombok.Data;

import java.util.List;


@Data
public class RegistrationRequest {
    private String firstName;
    private String surname;
    private String lastName;
    private String email;
    private String password;
    private List<Role> roles;
}

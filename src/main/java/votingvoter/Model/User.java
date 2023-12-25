package votingvoter.Model;


import votingvoter.Model.Enum.Permission;
import votingvoter.Security.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Data
@Audited
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    @Email
    @NotNull
    @NaturalId(mutable = true)
    private String email;

    private String phone;

    private Permission permission;

    ///////////////////////////////////////////////////////////////////////////
    //////////////////////////// SECURITY THINGS //////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    private String password;

    private boolean isEnabled = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;


    ///////////////////////////////////////////////////////////////////////////
    //////////////////////////// SOME OTHER THINGS ////////////////////////////
    ///////////////////////////////////////////////////////////////////////////

    public User(String firstName, String lastName, String email,
                String password, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getName() { return lastName + " " + firstName;}

    public void setName(String name) {

    }
}

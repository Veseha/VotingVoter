package votingvoter.Security.user;//package votingvoter.Security.user;
//
//import votingvoter.model.User;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.NaturalId;
//import org.hibernate.envers.Audited;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Collection;
//
//
//@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@Audited
//@Table(name = "_user")
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String firstName;
//    private String lastName;
//    @NaturalId(mutable = true)
//    private String email;
//    private String password;
//    private boolean isEnabled = false;
//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "user_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//    private Collection<Role> roles;
//
//    @OneToOne
//    private User employee;
//
//
//
//    public User(String firstName, String lastName, String email,
//                String password, Collection<Role> roles) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.password = password;
//        this.roles = roles;
//    }
//}

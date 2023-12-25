package votingvoter.Repository;

import votingvoter.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRep extends JpaRepository<User, Long> {

    public Optional<User> findByEmail(String email);
//    public  User findFirstByEmail(String email);
//    public User findByPrivilegesAndTeam(Privileges privileges, Team team);
    @Modifying
    @Query(value = "UPDATE User u set u.firstName =:firstName,"+
            " u.lastName =:lastName," + "u.email =:email where u.id =:id")
    void update(String firstName, String lastName, String email, Long id);

    public List<User> findByTeamIsNotNull();
}
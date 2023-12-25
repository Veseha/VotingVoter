package votingvoter.Security.user;

// import votingvoter.Model.Consts.EPrivileges;
//import votingvoter.Model.Department;

import votingvoter.Model.User;
import votingvoter.Repository.EmployeeRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class PrincipalService {
    private final EmployeeRep employeeRep;

    public User getEmployee(Principal principal){
//        System.out.println(principal);
//        System.out.println(principal.getName());
//        System.out.println(employeeRep.findByEmail(principal.getName()));
//        System.out.println(employeeRep.findByEmail(principal.getName()).get());
        return employeeRep.findByEmail(principal.getName()).get();
    }
    public boolean isRegistered(Principal principal){
        User employee = getEmployee(principal);
        return true;
    }
//    public Team getTeam(Principal principal){
//        if (isRegistered(principal)){
//            return getEmployee(principal).getTeam();
//        }
//        System.out.println("--- ERROR --- the user isn't registered");
//        return null;
//    }
//    public Department getDepartment(Principal principal){
//        if (isRegistered(principal)){
//            return getEmployee(principal).getTeam().getDepartment();
//        }
//        System.out.println("--- ERROR --- the user isn't registered");
//        return null;
//    }
//    public boolean compareTeam(Principal principal, Team team2){
//        Team team1 = getTeam(principal);
//        return team1.getId().equals(team2.getId());
//    }
//    public boolean compareDepartment(Principal principal, Department department2){
//        Department department1 = getDepartment(principal);
//        return department1.getId().equals(department2.getId());
//    }
    public boolean isAdmin(Principal principal){
        User employee = getEmployee(principal);
//        return employee.getPrivileges().getName() == EPrivileges.ADMIN;

        return false;
    }
}

package votingvoter.ModelService;


import votingvoter.Model.Enum.Permission;
import votingvoter.Model.User;
import votingvoter.Repository.EmployeeRep;
import votingvoter.Security.user.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRep employeeRep;
    private final PrincipalService principalService;

    // GET
    public User get(Long id){
        return employeeRep.getReferenceById(id);
    }
    public String getEmail(User employee){return employee.getEmail();}
    public User getNew(){return new User();}
    
    
    public List<User> getAllRegisteredEmployees(){
        return employeeRep.findByTeamIsNotNull();
    }
    public User getEmployeeByEmail(String email){
        return employeeRep.findByEmail(email).get();
    }
   

    // SET
    public void set(User employee){
        User employee1 = employeeRep.getReferenceById(employee.getId());
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employeeRep.save(employee1);
    }

    public void setNew(User employee){
        User employee1 = employeeRep.getReferenceById(employee.getId());
        employee1.setEnabled(true);
        employeeRep.save(employee1);
    }


    // UPDATE

    // DELETE
    public void delete(User employee){
        employee.setEnabled(false);
        employee.setPassword("fdgdtretehtrhtrtr");
        employeeRep.save(employee);
    }

    // IS
    public boolean isAdminAccess(User employee){
        return employee.getPermission() == Permission.ADMIN;
    }

   


}


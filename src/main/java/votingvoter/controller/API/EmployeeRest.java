package votingvoter.controller.API;

import votingvoter.Model.User;
import votingvoter.ModelService.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRest {
    @Autowired
    UserSer employeeService;


    @GetMapping("/getall")
    public List<User> getAllEmployee(){
        return employeeService.getAllRegisteredEmployees();
    }
}
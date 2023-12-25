package votingvoter.controller;

//import votingvoter.Model.Consts.EPrivileges;

import votingvoter.Model.Enum.Permission;
import votingvoter.Model.User;
import votingvoter.ModelService.UserSer;
import votingvoter.Security.user.PrincipalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class UserContrl {

    private final PrincipalService principalS;
    private final UserSer employeeS;


    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") User employee_ent, Model model, Principal principal) {
        employeeS.setNew(employee_ent);
        return "redirect:/employee/list";
    }



    @GetMapping("/list")
    public String showEmployeeList(Model model,  Principal principal) {

        User employee = principalS.getEmployee(principal);
        if(employee.getPermission() == Permission.ADMIN) {
            model.addAttribute("employeeList", employeeS.getAllRegisteredEmployees());
            model.addAttribute("contentFragment", "fragments/employee/employee-list");
            model.addAttribute("pageTitle", "List User");
        }
        return "template";
    }

    @GetMapping("/edit/{id}")
    public String showEmployeeEditForm(Model model,  Principal principal, @PathVariable("id") Long id) {

        User employee = principalS.getEmployee(principal);
        User employee_ent = employeeS.get(id);
//        if(ModelAccess.apply(model, employeeS.isCanEdit(employee, employee_ent)) || employeeS.isAdminAccess(employee)){
            model.addAttribute("employee_id", id);
            model.addAttribute("employee", employee_ent);
            model.addAttribute("contentFragment", "fragments/employee/employee-edit");
            model.addAttribute("pageTitle", "Edit User");
//        }
        return "template";

    }

    @PostMapping("/edit/{id}")
    public String editEmployee(@ModelAttribute("employee") User employee_ent, @PathVariable("id") Long id, Principal principal, Model model) {
        User employee = principalS.getEmployee(principal);
//        if(ModelAccess.apply(model, employeeS.isCanEdit(employee, employee_ent)) || employeeS.isAdminAccess(employee)){
           employeeS.set(employee_ent);
           return "redirect:/employee/list";

//        }
//        return "template";
//        User employee_ex = employeeRep.getReferenceById(id);
//        employee_ex.setName(employee.getName());
////        employee_ex.setPrivileges(employee.getPrivileges());
//        employee_ex.setEmail(employee.getEmail());
//        employee_ex.setTeam(employee.getTeam());
//        employeeRep.save(employee_ex);
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("id_empl") Long id, Principal principal, Model model) {
        User employee = principalS.getEmployee(principal);
        User employee_ent = employeeS.get(id);
//        if(ModelAccess.apply(model, employeeS.isCanDelete(employee, employee_ent)) || employeeS.isAdminAccess(employee)){
            employeeS.delete(employee_ent);
            return "redirect:/employee/list";

//        }
//        return "template";

//        User employee = employeeRep.getReferenceById(id);
//        EventNotifications en = new EventNotifications(messagesRep, employeeRep, privilegesRep, executorPPWRep, notificationRep, subjectsRep);
//        Boolean is_sent = en.SendNotificationDeleteEmployee(employee, getJavaMailSender);
//        if(is_sent){
//            employeeRep.delete(employee);
//            return "redirect:/employee/list";
//        }
//        else{
//            System.out.println(is_sent);
//            return "redirect:/not_found_email";
//        }
    }

    @GetMapping("/not_found_email")
    public String NotFoundEmail(){
        return "fragments/employee/not_found";
    }
}

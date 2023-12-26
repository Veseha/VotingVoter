package votingvoter.controller;

import votingvoter.Model.User;
import votingvoter.ModelService.UserSer;
import votingvoter.Security.user.PrincipalService;
import votingvoter.Security.utility.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
public class MainPage {

    private final UserSer employeeS;
    private final PrincipalService principalS;

    @GetMapping("/")
    public String homePage(Model model, Principal principal){
        System.out.println(CurrentUser.getEmail(principal));
        model.addAttribute("contentFragment", "fragments/help");
        model.addAttribute("pageTitle", "Home");

        return "template";
    }
    @GetMapping("/help")
    public String helpPage(Model model, Principal principal){
        System.out.println(CurrentUser.getEmail(principal));
        model.addAttribute("contentFragment", "fragments/help");
        model.addAttribute("pageTitle", "Home");

        return "template";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }


}

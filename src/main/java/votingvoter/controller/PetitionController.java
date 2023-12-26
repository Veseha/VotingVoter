package votingvoter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import votingvoter.Model.Petition;
import votingvoter.Model.User;
import votingvoter.ModelService.PetitionService;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Security.user.PrincipalService;

import java.security.Principal;

@Controller
@RequestMapping("/petition")
@RequiredArgsConstructor
public class PetitionController {
    private final PrincipalService principals;
    private final PetitionRepository petitionRep;
    private final PetitionService petitionService;

    @GetMapping("/list")
    public String getPetitionList(Model model){
        model.addAttribute("petitions", petitionService.getPetitionList());
        return "displayPetitions";
    }

    @GetMapping("/creationForm")
    public String getPetitionForm(){
        return "createPetition";
    }

    @PostMapping("/add")
    public String addPetition( Petition petition){
        petitionService.createPetition(petition);
        return "redirect:/petition/list";
    }

    @PostMapping("/del")
    public String deletePetition(@ModelAttribute("petition") Petition petition, Principal principal, Model model){
        petitionService.deletePetition(petition, principal);
        return "redirect:/petition/list";
    }

}

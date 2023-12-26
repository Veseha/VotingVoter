package votingvoter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import votingvoter.Model.Petition;
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
        model.addAttribute("contentFragment", "/frag/petition/display-petitions");
        model.addAttribute("pageTitle", "List petition");

        return "template";
    }

    @GetMapping("/add")
    public String getPetitionForm(Model model){
        model.addAttribute("contentFragment", "/frag/petition/create-petitions");
        model.addAttribute("pageTitle", "Add petition");

        return "template";
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

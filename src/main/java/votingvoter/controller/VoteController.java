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
import votingvoter.ModelService.VoteService;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Repository.VoteRep;
import votingvoter.Security.user.PrincipalService;

import java.security.Principal;

@Controller
@RequestMapping("/vote")
@RequiredArgsConstructor
public class VoteController {
    private final PrincipalService principals;
    private final PetitionService petitionService;
    private final VoteService voteService;

    @GetMapping("/list")
    public String getPetitionList(Model model, Principal principal){
        model.addAttribute("petitions", petitionService.getPetitionList());
        model.addAttribute("userid", principals.getEmployee(principal).getUserId());
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
    public String addPetition(Petition petition, Principal principal){
        petitionService.createPetition(petition, principal);
        return "redirect:/petition/list";
    }

    @PostMapping("/del")
    public String deletePetition(@ModelAttribute("petition") Petition petition, Principal principal, Model model){
//        System.out.println(petition.getPetitionId());
        petitionService.deletePetition(petition, principal);
        return "redirect:/petition/list";
    }
}

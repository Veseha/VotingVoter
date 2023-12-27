package votingvoter.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import votingvoter.Model.Petition;
import votingvoter.Model.Vote;
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

//    @GetMapping("/list")
//    public String getPetitionList(Model model, Principal principal){
//        model.addAttribute("petitions", petitionService.getPetitionList());
//        model.addAttribute("userid", principals.getEmployee(principal).getUserId());
//        model.addAttribute("contentFragment", "/frag/petition/display-petitions");
//        model.addAttribute("pageTitle", "List petition");
//
//        return "template";
//    }

    @GetMapping("/{id}")
    public String voteForm(Model model,  @PathVariable("id") Long id, Principal principal){
        Petition petition =  petitionService.getPetiton(id);
        if(!voteService.isAlreasyVoted(principal, petition)){
            model.addAttribute("contentFragment", "/frag/petition/send-vote");
            model.addAttribute("pageTitle", "Vote");
            model.addAttribute("petition", petition);
        }
        else
            model.addAttribute("contentFragment", "/fragment/access-denied");
        return "template";
    }

    @PostMapping("/add/{id}")
    public String addPetition(@ModelAttribute("vote") Boolean vote, Principal principal, @PathVariable("id") Long id, Model model){
        Petition petition = petitionService.getPetiton(id);
        if(!voteService.isAlreasyVoted(principal, petition)){
            petitionService.createPetition(petition, principal);
            voteService.addVote(vote, principal, petition);
            return "redirect:/petition/list";
        }
        model.addAttribute("contentFragment", "/fragment/access-denied");
        return "template";
    }
}

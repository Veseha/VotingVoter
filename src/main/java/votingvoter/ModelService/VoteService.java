package votingvoter.ModelService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import votingvoter.Model.Petition;
import votingvoter.Model.Vote;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Repository.VoteRep;
import votingvoter.Security.user.PrincipalService;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class VoteService {
    private final PetitionRepository petitionRep;
    private final PrincipalService principalService;
    private final DateService dateService;
    private final VoteRep voteRep;

    public void addVote(@NotNull Boolean vote, Principal principal, Petition petition){
        Vote newVote = new Vote();
        newVote.setUser(principalService.getEmployee(principal));
        newVote.setVoteTime(dateService.getCurrentDate());
        newVote.setVote(vote);
        newVote.setPetitionId(petition);
        voteRep.save(newVote);
    }

    public boolean isAlreasyVoted(Principal principal, Petition petition){
        return voteRep.findAllByPetitionIdAndUser(petition, principalService.getEmployee(principal)).isEmpty();
    }
    public List<Vote> getVotesByPetittion(Petition petition){
        return voteRep.findAllByPetitionId(petition);
    }

    public void nullifyReference(Vote vote){
        vote.setPetitionId(null);
    }
}

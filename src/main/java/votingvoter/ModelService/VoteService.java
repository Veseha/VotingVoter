package votingvoter.ModelService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import votingvoter.Model.Enum.Status;
import votingvoter.Model.Petition;
import votingvoter.Model.Vote;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Repository.VoteRep;
import votingvoter.Security.user.PrincipalService;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final PetitionRepository petitionRep;
    private final PrincipalService principalService;
    private final DateService dateService;
    private final VoteRep voteRep;

    public void addVote(@NotNull Vote vote, Principal principal, Petition petition){
//        voteRep.save(vote);
        Vote newVote = voteRep.getReferenceById(vote.getVoteId());
        newVote.setUser(principalService.getEmployee(principal));
        newVote.setVoteTime(dateService.getCurrentDate());
        newVote.setVote(vote.getVote());
        newVote.setPetitionId(petition);
        voteRep.save(newVote);
    }

    public boolean isAlreasyVoted(Principal principal, Petition petition){
        return !voteRep.findAllByPetitionIdAndUser(petition, principalService.getEmployee(principal)).isEmpty();
    }
    public List<Vote> getVotesByPetittion(Petition petition){
        return voteRep.findAllByPetitionId(petition);
    }
}

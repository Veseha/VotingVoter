package votingvoter.ModelService;

import com.google.common.collect.Iterables;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import votingvoter.Model.Enum.Status;
import votingvoter.Model.Petition;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Repository.VoteRep;
import votingvoter.Security.user.PrincipalService;

import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.text.DateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class PetitionService {
    private final PetitionRepository petitionRep;
    private final PrincipalService principals;
    private final DateService dateService;
    private final VoteRep voteRep;
    public void createPetition(@NotNull Petition petition, Principal principal){

        Petition newPetition = new Petition();
        petitionRep.save(newPetition);
        newPetition.setHeader(petition.getHeader());
        newPetition.setText(petition.getText());
        newPetition.setCreated(dateService.getCurrentDate());
        newPetition.setMinNumberVotes(petition.getMinNumberVotes());
        newPetition.setExpirationTime(petition.getExpirationTime());
        newPetition.setStatus(Status.OPEN);
        newPetition.setUser(principals.getEmployee(principal));
        newPetition.setCountOfVote(voteRep.findAllByPetitionId(newPetition).size());
        petitionRep.save(newPetition);

    }

    public Iterable<Petition> getPetitionList(){
        return petitionRep.findAllByStatusNot(Status.CLOSE);
    }

    public Iterable<Petition> getPetitionListOfUser(Principal principal){
        return petitionRep.findAllByUserUserId(principals.getEmployee(principal).getUserId());
    }

    public Iterable<Petition> getPetitionListAll(){
        return petitionRep.findAll(PageRequest.of(0, 10)).getContent();
    }

    public void deletePetition(Petition petition_, Principal principal){
        Petition petition = petitionRep.getReferenceById(petition_.getPetitionId());
        if(principals.getEmployee(principal) == petition.getUser()){
            petition.setStatus(Status.CLOSE);
            petitionRep.save(petition);
        }
    }
    public Petition getPetiton(Long id){
        return petitionRep.getReferenceById(id);
    }
}

package votingvoter.ModelService;

import com.google.common.collect.Iterables;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import votingvoter.Model.Enum.Status;
import votingvoter.Model.Petition;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Security.user.PrincipalService;

import java.security.Principal;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class PetitionService {
    private PetitionRepository petitionRep;
    private Date date;
    private final PrincipalService principals;
    private final DateService dateService;
    public void createPetition(Petition petition){
        Petition newPetition = petitionRep.getReferenceById(petition.getPetitionId());
        newPetition.setHeader(petition.getHeader());
        newPetition.setText(petition.getText());
        newPetition.setCreated(dateService.getCurrentDate());
        newPetition.setMinNumberVotes(petition.getMinNumberVotes());
        newPetition.setExpirationTime(petition.getExpirationTime());
        newPetition.setStatus(Status.OPEN);
        newPetition.setUser(petition.getUser());
        petitionRep.save(newPetition);
    }

    public Iterable<Petition> getPetitionList(){
        return petitionRep.findAll(PageRequest.of(0, 10)).getContent();
    }

    public void deletePetition(Petition petition, Principal principal){
        if(principals.getEmployee(principal) == petition.getUser() || principals.isAdmin(principal)){
            petitionRep.deleteById(petition.getPetitionId());
        }
    }
}
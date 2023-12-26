package votingvoter.ModelService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import votingvoter.Repository.PetitionRepository;
import votingvoter.Security.user.PrincipalService;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final PetitionRepository petitionRep;
    private final PrincipalService principals;
    private final DateService dateService;


}

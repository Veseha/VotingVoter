package votingvoter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import votingvoter.Model.Petition;
import votingvoter.Model.User;
import votingvoter.Model.Vote;

import java.util.List;

@Repository

public interface VoteRep extends JpaRepository<Vote, Long> {
    public List<Vote> findAllByPetitionId(Petition petition);
    public List<Vote> findAllByPetitionIdAndUser(Petition petition, User user);

}

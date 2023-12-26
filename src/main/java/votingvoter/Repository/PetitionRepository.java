package votingvoter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import votingvoter.Model.Petition;

public interface PetitionRepository extends JpaRepository<Petition, Long> {

}

package votingvoter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import votingvoter.Model.Enum.Status;
import votingvoter.Model.Petition;

import java.io.File;
import java.util.List;

public interface PetitionRepository extends JpaRepository<Petition, Long> {
    public List<Petition> findAllByStatusNot(Status status);

    public List<Petition> findAllByUserUserId(Long id);

}

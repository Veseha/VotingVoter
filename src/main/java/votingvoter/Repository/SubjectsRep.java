package votingvoter.Repository;

import votingvoter.Model.Email.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectsRep extends JpaRepository<Subject, Long> {
    public List<Subject> findByStage(String stage);
    public List<Subject> findByStageAndLang(String stage, String lang);
}
package votingvoter.Repository;

import votingvoter.Model.Email.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRep extends JpaRepository<Messages, Long> {
    public List<Messages> findByStage(String stage);
    public List<Messages> findByStageAndLang(String stage, String lang);
}
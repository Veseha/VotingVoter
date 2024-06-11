package votingvoter.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import votingvoter.Model.Document;

import java.io.File;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}

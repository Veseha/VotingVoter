package votingvoter.Repository;

import org.springframework.content.commons.store.ContentStore;
import votingvoter.Model.Document;

public interface DocumentContentStore extends ContentStore<Document, String> {
}

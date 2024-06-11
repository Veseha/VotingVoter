package votingvoter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

@Entity
@Data
@Table(name = "document")
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    @Lob
    private byte[] documentData;

    @ContentId private String contentId;
    @ContentLength private Long contentLength;

    private String contentMimeType = "text/plain";

    public Document(String fileName, String location) {
        this.name = fileName;
        this.location = location;
    }
}

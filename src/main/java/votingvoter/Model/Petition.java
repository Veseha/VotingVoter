package votingvoter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import votingvoter.Model.Enum.Status;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "petition")
@AllArgsConstructor
@NoArgsConstructor
public class Petition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petitionId;

    private String header;

    @Column(columnDefinition = "text") //error: value too long for var(255)
    private String text; // need to prepare migration script

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date expirationTime;

    private Integer minNumberVotes;

    @OneToMany(mappedBy = "petitionId", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Vote> votes;

    private Status status;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Lazy
    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User user;

    @OneToOne
    private Document document;

    private Integer countOfVote;

}

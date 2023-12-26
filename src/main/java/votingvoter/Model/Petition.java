package votingvoter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
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

    private String text;

    private Instant expirationTime;

    private Integer minNumberVotes;

    @OneToMany(mappedBy = "petitionId")
    private Set<Vote> votes;


    private Status status;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User user;

}

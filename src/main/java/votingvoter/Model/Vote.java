package votingvoter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@Table(name = "vote")
@AllArgsConstructor
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    private String vote_text;

    @NotNull
    private Boolean vote;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date voteTime;

    @ManyToOne
    @JoinColumn(name = "petitionId")
    @NotNull
    private Petition petitionId;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User user;

}

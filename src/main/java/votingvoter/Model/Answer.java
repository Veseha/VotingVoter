package votingvoter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "answer")
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date answerTime;

    @ManyToOne
    @JoinColumn(name = "userId")
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "answerOptionId")
    @NotNull
    private AnswerOption answerOptionId;
}

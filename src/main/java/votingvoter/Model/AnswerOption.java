package votingvoter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "answerOption")
@NoArgsConstructor
@AllArgsConstructor
public class AnswerOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String answerName;

    private String answerText;



    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    @NotNull
    private Question questionId;

    @OneToMany(mappedBy = "answerOptionId")
    private Set<Answer> answers;
}

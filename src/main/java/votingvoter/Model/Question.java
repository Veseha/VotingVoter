package votingvoter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "question")
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String questionName;

    private String description;

    private Boolean required = false;

    @ManyToOne
    @JoinColumn(name = "surveyId", nullable = false)
    @NotNull
    private Survey surveyId;

    @OneToMany(mappedBy = "questionId")
    private Set<AnswerOption> answers;
}

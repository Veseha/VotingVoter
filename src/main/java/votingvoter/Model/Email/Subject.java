package votingvoter.Model.Email;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Entity
@Data
//@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subject;

    @Column(name = "stage")
    @NotNull
    private String stage;

    @Column(name = "active")
    @NotNull
    private Boolean active;

    @Column(name = "subject", length = 2000)
    @NotNull
    private String subject;

    @Column(name = "lang", columnDefinition = "varchar(255) default 'RU'")
    private String lang = "RU";
}

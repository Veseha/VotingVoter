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
@Table(name = "Messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_message;

    @Column(name = "stage")
    @NotNull
    private String stage;

    @Column(name = "active")
    @NotNull
    private Boolean active;

    @Column(name = "message", length = 2000)
    @NotNull
    private String message;

    @Column(name = "lang", columnDefinition = "varchar(255) default 'RU'")
    private String lang = "RU";


}

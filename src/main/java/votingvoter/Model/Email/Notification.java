package votingvoter.Model.Email;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@Audited
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_message")
    private Messages message;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @Column(name = "event")
    private String event;

}

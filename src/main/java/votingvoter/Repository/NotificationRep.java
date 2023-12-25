package votingvoter.Repository;

import votingvoter.Model.Email.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRep extends JpaRepository<Notification, Long> {
//    public List<Notification> findByEvent(String event);
    public Notification findByEvent(String event);
}
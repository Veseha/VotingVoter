package votingvoter.ModelService;

//import votingvoter.Components.EmailNew.EventNotificationsAsync;
import votingvoter.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender getJavaMailSender;
    private final MessagesRep messagesRep;
    private final UserRep employeeRep;
    private final NotificationRep notificationRep;
    private final SubjectsRep subjectsRep;

//    public void sendCompleteMessage(PPW ppw){
//            System.out.println("enter");
//            Long id_ppw = ppw.getId();
//            System.out.println("Start sending finish message \"+\n" + LocalDateTime.now());
//            if(id_ppw != null) {
//                System.out.println(id_ppw);
////                PPW ppw_ = ppw;
//                if (Objects.equals(ppw.getId(), id_ppw)) {
//                    EventNotificationsAsync ena = new EventNotificationsAsync(ppw, getJavaMailSender, messagesRep, employeeRep, notificationRep, subjectsRep, EventNotificationsAsync.NotificationType.COMPLETED);
//                    ena.start();
//                    System.out.println("Message sent");
//                } else {
//                    System.out.println("ERROR, the " + id_ppw + " not found");
//                }
//            }
//        }

}

package votingvoter.Components.OLD;//package votingvoter.Components.Email;
//
//import votingvoter.Const;
//import votingvoter.Repository.*;
//import votingvoter.model.*;
//import votingvoter.model.MTM.ExecutorPPW;
//import org.springframework.context.annotation.Bean;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.util.logging.Logger;
//
//@Service
//public class SendFinishEmail extends Thread{
////    @Autowired
////    PPWRep ppwRep;
////    @Autowired
////    NERep neRep;
////    @Autowired
////    NETypeRep neTypeRep;
////    @Autowired
////    EmployeeRep employeeRep;
////    @Autowired
////    PrivilegesRep privilegesRep;
////    @Autowired
////    TeamRep teamRep;
////    @Autowired
////    StatusRep statusRep;
////    @Autowired
////    MessagesRep messagesRep;
////    @Autowired
////    ExecutorPPWRep executorPPWRep;
////    @Autowired
////    JavaMailSender getJavaMailSender;
//
//    SendEmailMethod sendEmailMethod;
//    Long id_ppw = 0L;
//
//    PPWRep ppwRep;
//    EmployeeRep employeeRep;
//    ExecutorPPWRep executorPPWRep;
//    MessagesRep messagesRep;
//    JavaMailSender getJavaMailSender;
//    NEPPWRep neppwRep;
//
//    public SendFinishEmail(SendEmailMethod sendEmailMethod, GetPPWId ppw, PPWRep ppwRep,
//                           EmployeeRep employeeRep,
//                           ExecutorPPWRep executorPPWRep,
//                           MessagesRep messagesRep,
//                           JavaMailSender getJavaMailSender,
//                           NEPPWRep neppwRep){
//        this.sendEmailMethod = sendEmailMethod;
//        this.id_ppw = ppw.id_ppw;
//        this.ppwRep = ppwRep;
//        this.employeeRep = employeeRep;
//        this.executorPPWRep = executorPPWRep;
//        this.messagesRep = messagesRep;
//        this.getJavaMailSender = getJavaMailSender;
//        this.neppwRep = neppwRep;
//    }
//    static final Logger LOGGER = Logger.getLogger(SendFinishEmail.class.getName());
////    public String getMess(String stage){
////        return messagesRep.findByStageAndLang(stage, "RU").get(0).getMessage();
////    }
//
//
//    @Bean
//    public String SendingFinishEmail(
//            PPWRep ppwRep,
////    NERep neRep,
////    NETypeRep neTypeRep,
//    EmployeeRep employeeRep,
////    PrivilegesRep privilegesRep,
////    TeamRep teamRep,
////    StatusRep statusRep,
//    ExecutorPPWRep executorPPWRep,
//            MessagesRep messagesRep,
//            JavaMailSender getJavaMailSender,
//            NEPPWRep neppwRep
//    ){
//
//        LOGGER.info("Start sending finish message "+
//                LocalDateTime.now());
//        SendEmailConfig sender = new SendEmailConfig();
//        if(id_ppw != null){
//            System.out.println(id_ppw);
//            PPW ppw = ppwRep.getReferenceById(id_ppw);
//            if (Objects.equals(ppw.getId(), id_ppw)){
//                LOGGER.info("Time for send final message");
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//                Team team = ppw.getTeam();
//                String name_ne = ppw.getnename(neppwRep, ppw);
//
////                NE ne = ppw.getNe_();
////                NEType netype = ne.getNetype();
//
//
//                ArrayList<String> name_employees = new ArrayList<>();
//                for (ExecutorPPW emp: executorPPWRep.findByppw(ppw)) {
//                    name_employees.add(emp.getEmployee().getName());
//                }
//
//                String middle_message = String.format(Const.message_about_work, Const.server_address + Const.page_qppw + ppw.getId(), Const.server_address + Const.page_ppw + ppw.getId(), ppw.getName(), ppw.getCrq(), team.getName(), Arrays.toString(name_employees.toArray(new String[0])), ppw.getPlaneddate(), ppw.getWorkdate(), name_ne, "Заглушка, потом напомните разрабу чтоб пофиксил netype.getName()", ppw.getTeam().getCity().getName());
//                String message = Const.message_template_1 + String.format(messagesRep.findByStageAndLang("completed", "RU").get(0).getMessage(), ppw.getPlaneddate().format(formatter), ppw.getName()) + Const.message_template_2 + middle_message + Const.message_template_3;
//                String subject = String.format(messagesRep.findByStageAndLang("sub_info", "RU").get(0).getMessage(), ppw.getName());
//
//                ArrayList<String> recievers = new ArrayList<String>();
//                LOGGER.info("team " + ppw.getTeam().getName() );
//                for (User empl: employeeRep.findByTeam(ppw.getTeam())) {
//                    LOGGER.info(empl.getName());
//                    recievers.add(empl.getEmail());
//                }
//                if(!recievers.isEmpty()){
//                    LOGGER.info("Not Empty");
//                    sendEmailMethod.SendEmailMet(recievers.toArray(new String[0]), subject, message, getJavaMailSender);
//                }
//                LOGGER.info("Message sent");
//            }
//            else{
//                LOGGER.warning("ERROR, the " + id_ppw + " not found");
//            }
//        }
//        return "";
//    }
//
//
//    public void run(){
//
//
//    }
//}
//

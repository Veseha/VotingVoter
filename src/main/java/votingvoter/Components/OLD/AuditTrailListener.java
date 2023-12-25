package votingvoter.Components.OLD;//package votingvoter.Components.Audit;
//
//import votingvoter.Repository.AuditRep;
//import votingvoter.model.Audit;
//import jakarta.persistence.PrePersist;
//import jakarta.persistence.PreRemove;
//import jakarta.persistence.PreUpdate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//
//@Component
//public class AuditTrailListener {
////    @Autowired
////    private AuditService auditService;
//
//    @Autowired
//    AuditRep auditRep;
//
//    Logger log = LoggerFactory.getLogger("audit-logs");
//
//    @PrePersist
//    public void beforeCreate(Object object) {
//        Audit s = createAudit(object, "CREATE");
//        auditRep.save(s);
//        log.info(s.toString());
//    }
//
//    @PreUpdate
//    private void beforeUpdate(Object object) {
//        log.info(createAudit(object, "UPDATE").toString());
//    }
//
//    @PreRemove
//    private void beforeRemove(Object object) {
//        log.info(createAudit(object, "REMOVE").toString());
//    }
//    public Audit createAudit(Object object, String type) {
//        Audit auditDTO = new Audit();
//        auditDTO.setEntity(object.getClass().getSimpleName());
//        auditDTO.setOperation(type);
////        auditDTO.setModifiedBy(SecurityUtils.getCurrentUserLogin().get());
//        auditDTO.setModifiedBy("Test");
//        auditDTO.setModifiedAt(LocalDateTime.now());
//        auditDTO.setPayload(object.toString());
//
//        return auditDTO;
//    }
//}

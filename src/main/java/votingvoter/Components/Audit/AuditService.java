package votingvoter.Components.Audit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditService {
    //Если вы здесь, значит у вас есть вопросы к аудиту данных (если их нет,
    // закройте файл и ничего не трогайте в строках где что либо написано о аудите
    // если же вопросы есть, то мой совет, читайте полностью документацию по аудиту в спринге,
    // сносите все что тут есть, и пишите заново.
    @PersistenceContext
    private EntityManager entityManager;

//    public List<PPW> getAuditedData(Long entityId) {
//        AuditReader auditReader = AuditReaderFactory.get(entityManager);
//        List<Number> revisions = auditReader.getRevisions(PPW.class, entityId);
//        List<PPW> ppws = new ArrayList<>();
//
//        List<Number> revisions_ne = auditReader.getRevisions(NEPPW.class, entityId);
//        List<NEPPW> neppws = new ArrayList<>();
//        for (Number rev: revisions) {
//             ppws.add(auditReader.find(PPW.class, entityId, rev));
//        }
//        return ppws;
//    }
//    public List<Task> getAuditedDataTask(Long entityId) {
//        AuditReader auditReader = AuditReaderFactory.get(entityManager);
//        List<Number> revisions = auditReader.getRevisions(Task.class, entityId);
//        List<Task> tasks = new ArrayList<>();
//
//        for (Number rev: revisions) {
//            tasks.add(auditReader.find(Task.class, entityId, rev));
//        }
//        return tasks;
//    }

}

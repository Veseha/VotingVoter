package votingvoter.Components.OLD;//package votingvoter.Components.OLD;
//
//import votingvoter.Repository.HistoryRep;
//import votingvoter.model.History;
//import votingvoter.model.PPW;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.time.LocalDate;
//import java.util.Objects;







//@Service
//public class HistoryChange {
//    @Autowired
//    HistoryRep historyRep;
//
//    @Bean
//    public String AddHistoryRow(
//            String column_cell,
//            String id_cell,
//            String before,
//            String after,
//            String employee,
//            String type
//    ){
//        if(!Objects.equals(id_cell, "")){
//            History historyRow = new History();
//            historyRow.setColumn_cell(column_cell);
//            historyRow.setId_cell(Long.parseLong(id_cell));
//            historyRow.setBefore(before);
//            historyRow.setAfter(after);
//            historyRow.setEmployee(employee);
//            historyRow.setType(type);
//            historyRow.setDate_change(LocalDate.now());
//            historyRep.save(historyRow);
//        }
//        return "";
//    }
//}

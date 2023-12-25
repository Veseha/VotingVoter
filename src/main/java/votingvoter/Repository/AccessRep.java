//package votingvoter.Repository;
//
//
//import votingvoter.Model.AccessTree.Access;
//import votingvoter.Model.AccessTree.LevelDict;
//import votingvoter.Model.Consts.EModels;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface AccessRep extends JpaRepository<Access, Long> {
//    List<Access> findByInfluencelvl(LevelDict influencelvl);
//    List<Access> findByPrivlvl(LevelDict privlvl);
////    List<Access> findByPrivilege(Privileges privileges);
//    List<Access> findByModel(EModels models);
////    Access findByModelAndPrivilege(EModels models, Privileges privileges);
//    Optional<Access> findByModelAndPrivlvlAndInfluencelvl(EModels models, LevelDict priv_lvl, LevelDict influence_lvl);
////    Access findfirstByModelAndPrivlvl(EModels models, LevelDict priv_lvl);
//
//    List<Access> findByModelAndPrivlvl(EModels model, LevelDict priv_lvl);
//
//
//}

package votingvoter.Security.registration.token;


//import votingvoter.Security.user.User;
import votingvoter.Model.User;

import java.util.Optional;


public interface IVerificationTokenService {
    String validateToken(String token);
    void saveVerificationTokenForUser(User user, String token);
    Optional<VerificationToken> findByToken(String token);


    void deleteUserToken(Long id);
}

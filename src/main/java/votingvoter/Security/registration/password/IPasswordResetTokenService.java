package votingvoter.Security.registration.password;


//import votingvoter.Security.user.User;
import votingvoter.Model.User;

import java.util.Optional;

/**
 * @author Sampson Alfred
 */

public interface IPasswordResetTokenService {
    String validatePasswordResetToken(String theToken);

    Optional<User> findUserByPasswordResetToken(String theToken);

    void resetPassword(User theUser, String password);

    void createPasswordResetTokenForUser(User user, String passwordResetToken);
}

package votingvoter.Security.utility;

import java.security.Principal;

public class CurrentUser {
    static public String getEmail(Principal principal){
        if(principal != null){
            return principal.getName();
        }
        return "";
    }
}

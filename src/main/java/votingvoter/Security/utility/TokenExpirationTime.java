package votingvoter.Security.utility;

import java.util.Calendar;
import java.util.Date;


public class TokenExpirationTime {
    private static final int EXPIRATION_TIME = 60*24*30;

    public static Date getExpirationTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, EXPIRATION_TIME);
        return new Date(calendar.getTime().getTime());
    }
}

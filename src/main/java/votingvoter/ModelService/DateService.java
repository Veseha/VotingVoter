package votingvoter.ModelService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class DateService {
    public Date getCurrentDate(){
        return new Date();
    }
}

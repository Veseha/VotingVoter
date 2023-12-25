package votingvoter.Security.security;

//import votingvoter.Security.user.UserRepository;
import votingvoter.Repository.EmployeeRep;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EndToEndUserDetailsService implements UserDetailsService {
    private final EmployeeRep userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .map(EndToEndUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}

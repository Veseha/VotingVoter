package votingvoter.ModelService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties("storage")
@Component
public class FileStorageProperties {

    private String location = "upload-dir";

}

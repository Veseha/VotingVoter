package votingvoter.Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import votingvoter.Exceptions.FileNotFoundException;
import votingvoter.Exceptions.StorageException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;


@Repository
    public class FileSystemRepository {
    public FileSystemResource findInFileSystem(String location){
        try{
            return new FileSystemResource(Paths.get(location));
        } catch (Exception e){
            throw new StorageException("Failed to find file", e);
        }
    }

}

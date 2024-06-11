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


@Repository
    public class FileSystemRepository {
    String RESOURCE_DIR = FileSystemRepository.class.getResource("/").getPath();

    public String saveFile(byte[] content, String fileName) throws Exception{
        try {
            Path newFile = Paths.get(RESOURCE_DIR + new Date().getTime() + "-" + fileName);
            Files.createDirectories(newFile.getParent());

            Files.write(newFile, content);

            return newFile.toAbsolutePath().toString();
        } catch (Exception e){
            throw new FileNotFoundException("Unable to get path");
        }
    }

    public FileSystemResource findInFileSystem(String location){
        try{
            return new FileSystemResource(Paths.get(location));
        } catch (Exception e){
            throw new StorageException("Failed to find file", e);
        }
    }

}

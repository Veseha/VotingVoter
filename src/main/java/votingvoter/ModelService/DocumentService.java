package votingvoter.ModelService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import votingvoter.Exceptions.FileNotFoundException;
import votingvoter.Exceptions.StorageException;
import votingvoter.Model.Document;
import votingvoter.Repository.DocumentContentStore;
import votingvoter.Repository.DocumentRepository;
import votingvoter.Repository.FileSystemRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private Path rootLocation;
    private final FileSystemRepository fileSystemRepository;
    private final DocumentRepository docRep;
    private final DocumentContentStore contentStore;
    private final FileStorageProperties fileStorageProperties;

    @Autowired
    public void init() {
        if(fileStorageProperties.getLocation().trim().isEmpty()) {
            throw new StorageException("File cannot be empty");
        }
        rootLocation = Paths.get(fileStorageProperties.getLocation()).toAbsolutePath();

        System.out.println("initialized successfully");
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException exception) {
            throw new StorageException("Failed to initialize storage", exception);
        }
    }

    public void saveContent(MultipartFile file) throws Exception {
        Optional<Document> f = docRep.findById(store(file));

        if(f.isPresent()){
            f.get().setContentMimeType(file.getContentType());

            contentStore.setContent(f.get(), file.getInputStream());
            docRep.save(f.get());

        } else {
            throw new FileNotFoundException("Unable to store file");
        }
    }

    public Long store(MultipartFile file) throws Exception{
        try{
            if (file.isEmpty()){
                throw new StorageException("Failed to store file");
            }
            Path destinationFile = rootLocation.resolve(Paths.get(file.getOriginalFilename()).normalize());
            if(!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())){
                throw new StorageException("Cannot store file outside directory");
            }
            try(InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return docRep.save(new Document(file.getOriginalFilename(), destinationFile.toFile().getPath())).getId();

        } catch (IOException exception){
            throw new StorageException("Failed to store file.", exception);
        }
    }

    public FileSystemResource find(Long fileId){
        Document document = docRep.findById(fileId).orElseThrow(() -> new FileNotFoundException("unable to find file by id"));
        return fileSystemRepository.findInFileSystem(document.getLocation());
    }

    public Stream<Path> loadAll(){
        try{
            return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
        } catch (IOException exception){
            throw new StorageException("Failed to read stored files", exception);
        }
    }

    public Path load(String filename){
        return this.rootLocation.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new FileNotFoundException(
                        "Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Could not read file: " + filename, e);
        }
    }

    public void deleteAll(){
        FileSystemUtils.deleteRecursively(this.rootLocation.toFile());
    }

    public ResponseEntity<?> getContent(Long id) throws Exception{
        Optional<Document> f = docRep.findById(id);

        if (f.isPresent()){
            InputStreamResource inputStreamResource = new InputStreamResource(contentStore.getContent(f.get()));
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentLength(f.get().getContentLength());
            httpHeaders.set("Content-type", f.get().getContentMimeType());

            return new ResponseEntity<Object>(inputStreamResource, httpHeaders, HttpStatus.OK);
        }
        return null;
    }
}

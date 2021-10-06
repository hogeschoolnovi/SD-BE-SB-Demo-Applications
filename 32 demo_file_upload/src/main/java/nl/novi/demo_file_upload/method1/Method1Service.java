package nl.novi.demo_file_upload.method1;

import nl.novi.demo_file_upload.exceptions.FileStorageException;
import nl.novi.demo_file_upload.exceptions.RecordNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
public class Method1Service {

    @Value("${app.upload.dir:${user.home}}")
    private String uploadDirectory;  // relative to root
    private final Path uploads = Paths.get("uploads");

    @Autowired
    private Method1Repository repository;

    public void init() {
        try {
            Files.createDirectory(uploads);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    public Iterable<Method1File> getFiles() {
        return repository.findAll();
    }

    public long uploadFile(Method1RequestDto method1Dto) {

        MultipartFile file = method1Dto.getFile();

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
        Path copyLocation = this.uploads.resolve(file.getOriginalFilename());

        try {
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new FileStorageException("Could not store file " + originalFilename + ". Please try again!");
        }

        Method1File newFileToStore = new Method1File();
        newFileToStore.setFileName(originalFilename);
        newFileToStore.setLocation(copyLocation.toString());
        newFileToStore.setTitle(method1Dto.getTitle());
        newFileToStore.setDescription(method1Dto.getDescription());

        Method1File saved = repository.save(newFileToStore);

        return saved.getId();
    }

    public void deleteFile(long id) {
        Optional<Method1File> stored = repository.findById(id);

        if (stored.isPresent()) {
            String filename = stored.get().getFileName();
            Path location = this.uploads.resolve(filename);
            try {
                Files.deleteIfExists(location);
            }
            catch (IOException ex) {
                throw new RuntimeException("File not found");
            }

            repository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public Method1ResponseDto getFileById(long id) {
        Optional<Method1File> stored = repository.findById(id);

        if (stored.isPresent()) {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand("download").toUri();

            Method1ResponseDto responseDto = new Method1ResponseDto();
            responseDto.setFileName(stored.get().getFileName());
            responseDto.setTitle(stored.get().getTitle());
            responseDto.setDescription(stored.get().getDescription());
            responseDto.setMediaType(stored.get().getMediaType());
            responseDto.setDownloadUri(uri.toString());
            return responseDto;
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    public boolean fileExistsById(long id) {
        return repository.existsById(id);
    }

    public Resource downloadFile(long id) {
        Optional<Method1File> stored = repository.findById(id);

        if (stored.isPresent()) {
            String filename = stored.get().getFileName();
            Path path = this.uploads.resolve(filename);

            Resource resource = null;
            try {
                resource = new UrlResource(path.toUri());
                return resource;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else {
            throw new RecordNotFoundException();
        }

        return null;
    }

}
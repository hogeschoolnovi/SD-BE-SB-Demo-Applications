package nl.novi.demo_file_upload.method2;

import nl.novi.demo_file_upload.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class Method2Service {

    @Autowired
    private Method2Repository repository;

    public Iterable<Method2File> getFiles() {
        return repository.findAll();
    }

    public long uploadFile(MultipartFile file) {

        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

        Method2File newFileToStore = new Method2File();
        newFileToStore.setFileName(originalFilename);

        Method2File storedFile = repository.save(newFileToStore);

        return storedFile.getId();
    }

    public void deleteFile(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        repository.deleteById(id);
    }

    public Optional<Method2File> getFileById(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        return repository.findById(id);
    }

    public boolean fileExistsById(long id) {
        return repository.existsById(id);
    }

}
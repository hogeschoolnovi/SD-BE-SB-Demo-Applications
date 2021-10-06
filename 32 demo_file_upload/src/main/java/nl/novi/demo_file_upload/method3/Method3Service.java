package nl.novi.demo_file_upload.method3;

import nl.novi.demo_file_upload.exceptions.RecordNotFoundException;
import nl.novi.demo_file_upload.method1.Method1File;
import nl.novi.demo_file_upload.method1.Method1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class Method3Service {

    @Autowired
    private Method1Repository repository;

    public Iterable<Method1File> getFiles() {
        return repository.findAll();
    }

    public long uploadFile(MultipartFile file) {
//        Method3File newFile = repository.save(file);
//        return newFile.getId();
        return 0L;
    }

    public void deleteFile(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        repository.deleteById(id);
    }

    public Optional<Method1File> getFileById(long id) {
        if (!repository.existsById(id)) throw new RecordNotFoundException();
        return repository.findById(id);
    }

    public boolean fileExistsById(long id) {
        return repository.existsById(id);
    }

}
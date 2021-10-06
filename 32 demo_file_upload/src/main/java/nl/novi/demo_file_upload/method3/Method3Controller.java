package nl.novi.demo_file_upload.method3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/method3/files")
@CrossOrigin
public class Method3Controller {

    @GetMapping
    public ResponseEntity<Object> getFilesInfo() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("id")
    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("id/file")
    public ResponseEntity<Object> getFileData(@PathVariable long id) {
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> uploadFile() {
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteFile() {
        return ResponseEntity.noContent().build();
    }

}

package nl.novi.demo_file_upload.method2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/method2/files")
@CrossOrigin
public class Method2Controller {

    @GetMapping
    public ResponseEntity<Object> getFiles() {
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

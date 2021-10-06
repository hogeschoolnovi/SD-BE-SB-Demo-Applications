package nl.novi.demo_file_upload.method1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/method1")
@CrossOrigin
public class Method1Controller {

    @Autowired
    Method1Service methode1Service;

    @GetMapping("/files")
    public ResponseEntity<Object> getFiles() {
        Iterable<Method1File> files = methode1Service.getFiles();
        return ResponseEntity.ok().body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<Object> getFileInfo(@PathVariable long id) {
        Method1ResponseDto response = methode1Service.getFileById(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/files/{id}/download")
    public ResponseEntity downloadFile(@PathVariable long id) {
        Resource resource = methode1Service.downloadFile(id);
        String mediaType = "application/octet-stream";
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(mediaType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @PostMapping(value = "/files",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<Object> uploadFile(Method1RequestDto method1Dto) {
        long newId = methode1Service.uploadFile(method1Dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @DeleteMapping("/files/{id}")
    public ResponseEntity<Object> deleteFile(@PathVariable long id) {
        methode1Service.deleteFile(id);
        return ResponseEntity.noContent().build();
    }

}

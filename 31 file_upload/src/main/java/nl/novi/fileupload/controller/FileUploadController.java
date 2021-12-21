package nl.novi.fileupload.controller;

import nl.novi.fileupload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.URI;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/file-upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileUploadService.uploadFile(file);

        String message = "You successfully uploaded " + file.getOriginalFilename() + ".";

        URI location = null;
        return ResponseEntity.created(location).body(message);

    }

}
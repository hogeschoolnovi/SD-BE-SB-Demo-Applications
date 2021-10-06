package nl.novi.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @Autowired
    private HttpServletRequest request;

    @Value("${my.upload_location}")
    private String storageLocation;
//    private static String storageLocation = "/Users/peter/NOVI/Springboot/sandbox/25 file-upload-basic/uploaded_files/";

    @RequestMapping(value = "/file-upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {

        multipartFile.transferTo(new File(storageLocation + multipartFile.getOriginalFilename()));
        return "File successfully uploaded!";
    }

}

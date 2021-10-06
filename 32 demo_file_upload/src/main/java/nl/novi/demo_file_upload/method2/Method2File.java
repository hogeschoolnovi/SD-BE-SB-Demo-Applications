package nl.novi.demo_file_upload.method2;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "method_2_files")
public class Method2File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "file")
    @Lob
    private byte[] file;

    @Column(name = "uploaded_timestamp")
    private Date uploadedTimestamp;

    @Column(name = "uploaded_by_username")
    private String uploadedByUsername;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public Date getUploadedTimestamp() {
        return uploadedTimestamp;
    }

    public void setUploadedTimestamp(Date uploadedTimestamp) {
        this.uploadedTimestamp = uploadedTimestamp;
    }

    public String getUploadedByUsername() {
        return uploadedByUsername;
    }

    public void setUploadedByUsername(String uploadedByUsername) {
        this.uploadedByUsername = uploadedByUsername;
    }
}

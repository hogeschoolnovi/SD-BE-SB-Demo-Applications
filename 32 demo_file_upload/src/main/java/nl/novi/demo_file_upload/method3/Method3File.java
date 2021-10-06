package nl.novi.demo_file_upload.method3;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "method_3_files")
public class Method3File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "base64")
    private String base64;

    @Column(name = "uploaded_timestamp")
    private Date uploadedTimestamp;

    @Column(name = "uploaded_by_username")
    private String uploadedByUsername;

}

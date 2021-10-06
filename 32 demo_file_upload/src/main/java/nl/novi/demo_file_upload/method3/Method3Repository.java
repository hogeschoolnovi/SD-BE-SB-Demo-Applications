package nl.novi.demo_file_upload.method3;

import nl.novi.demo_file_upload.method1.Method1File;
import org.springframework.data.repository.CrudRepository;

public interface Method3Repository extends CrudRepository<Method1File, Long> {
}

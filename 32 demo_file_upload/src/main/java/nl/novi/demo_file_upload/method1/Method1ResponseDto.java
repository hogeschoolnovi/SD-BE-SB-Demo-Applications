package nl.novi.demo_file_upload.method1;

import org.springframework.web.multipart.MultipartFile;

public class Method1ResponseDto {
        private String title;
        private String description;
        private String fileName;
        private String mediaType;
        private String downloadUri;

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

        public String getFileName() {
                return fileName;
        }

        public void setFileName(String fileName) {
                this.fileName = fileName;
        }

        public String getMediaType() {
                return mediaType;
        }

        public void setMediaType(String mediaType) {
                this.mediaType = mediaType;
        }

        public String getDownloadUri() {
                return downloadUri;
        }

        public void setDownloadUri(String downloadUri) {
                this.downloadUri = downloadUri;
        }
}

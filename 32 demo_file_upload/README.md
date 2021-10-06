# Sample File Upload

This application provides 3 different methods of uploading a file to the backend and consequently downloadin the file fom the back-end

1. as a Multipart http-request stored as a file on disk
2. as a Multipart http-request stored as a LOB in the database
3. as a base64 encoded string stored in the database as a string

## Installation

1. Load project in IntelliJ.
   Maven will start synchronizing dependencies

2. Change PostgreSQL credientials in application.properties to your local settings:
   spring.datasource.url=jdbc:postgresql://localhost:5432/springboot
   spring.datasource.username=springboot
   spring.datasource.password=springboot

3. Create uploads directory in root directory of project. Or make sure it exists.
   E.g. .../SD-BE-SB-Demo-File-Upload/uploads

3. Run the project.
   If all is well de endpoints will be available
   
## Avaiable Endpoints

### Method 1:

*  POST http://localhost:8080/api/method1/files
   Upload file in multipart http request (see front-end usage below).
   Can also add title and description.
   Note: files will overwrite previous files with the same name.

*  GET http://localhost:8080/api/method1/files
   Get list of uploaded files without the file itself. Includes meta data and link to download file. 

*  GET http://localhost:8080/api/method1/files/{id}
   Get meta data and link to download file for specified file.
   
*  DELETE http://localhost:8080/api/method1/files/{id}
   Delete the specified file. Both the meta data and the file itself will be deleted.

*  GET http://localhost:8080/api/method1/files/{id}/download
   Download the file.

### Method 2:

Not implemented yet.

### Method 3:

Not implemented yet.

## Example Front-end usage with HTML

### Method 1:

* Upload file in multipart http request

```html
<form method="post" action="http://localhost:8080/api/method1/files" enctype="multipart/form-data">
   <div>
      <label>File to upload</label> <input type="file" id="file" name="file">
   </div>
   <div>
      <label>Title</label> <input type="text" id="title" name="title">
   </div>
   <div>
      <label>Description</label> <input type="text" id="description" name="description">
   </div>
   <input type="submit" value="Upload to webservice">
</form>
```

## Comments

1.  Java version 15
    openjdk-15.jdk
    
2.  Database PostgreSQL
    
3.  Cross-Origin is enabled for all endpoints and all origins.

4.  No authorization required.


#### Create a self-signed certificate

In src/main/resources execute the command:

keytool -genkey -keyalg RSA -alias certificate -keystore certificate.jks -storepass password -validity 365 -keysize 4096 -storetype pkcs12

#### Add to application properties

server.ssl.key-store=classpath:certificate.jks

server.ssl.key-store-type=pkcs12

server.ssl.key-store-password=password

server.ssl.key-password=password

server.ssl.key-alias=certificate

server.port=8443

#### Consume with

https://localhost:8443/

#### Disable SSL certificate verification

Make sure to allow this self-signed certificate
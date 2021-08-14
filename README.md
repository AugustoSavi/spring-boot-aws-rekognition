# Spring Boot Application to demonstrate AWS Rekognition

## Getting Started

* Set properties `aws.access-key` and `aws.secret-key` in application.properties or via command line properties (see https://aws.amazon.com/de/blogs/security/wheres-my-secret-access-key/)
* Start application
* Call POST `http://localhost:8080/api/images/moderation-labels` with form-data key=image and value=<your image>

### Curl Exemple

```shell
curl --request POST \
  --url http://localhost:8080/api/images/moderation-labels \
  --header 'Content-Type: multipart/form-data; \
  --form key=image \
  --form image=@/home/user/Downloads/image.jpg
```
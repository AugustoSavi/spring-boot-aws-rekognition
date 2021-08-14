# Spring Boot Application to demonstrate AWS Rekognition

## Como Usar?

```bash
# Clone o repositório
$ git clone https://github.com/AugustoSavi/spring-boot-aws-rekognition.git

# Entre no repositório
$ cd spring-boot-aws-rekognition

# renomeie o arquivo application-exemple.yml para application.yml

# coloque as informações no application.yml

# execute de docker compose
$  sudo docker-compose up

# abra um novo terminal e execute
$ mvn spring-boot:run
```

## Imagem usado no exemplo
![naoemaconha](https://user-images.githubusercontent.com/32443720/129457710-daadf2f6-f6d1-42ad-aae9-730768d23e4b.jpg)

### Você vai mandar um post assim
> note: only necessary parameter is the "keyFile"
```shell
curl --request POST \
  --url http://localhost:8081/api/images/moderation \
  --header 'Content-Type: application/json' \
  --data '{
  "id": "61180f73a4399c56ed2ac677",
  "bucketName": "imagens",
  "url": "http://localhost:9444/s3/imagens/naoemaconha.jpg",
  "keyFile": "naoemaconha.jpg",
  "status": "PROCESSANDO"
}'
```

### e vai receber assim

```json
{
  "sdkResponseMetadata": {
    "requestId": "requestId"
  },
  "sdkHttpMetadata": {
    "httpHeaders": {
      "Connection": "keep-alive",
      "Content-Length": "194",
      "Content-Type": "application/x-amz-json-1.1",
      "Date": "Fri, 01 Aug 2030 23:37:59 GMT",
      "x-amzn-RequestId": "x-amzn-RequestId"
    },
    "httpStatusCode": 200
  },
  "moderationLabels": [
    {
      "confidence": 99.9941,
      "name": "Drug Products",
      "parentName": "Drugs"
    },
    {
      "confidence": 99.9941,
      "name": "Drugs",
      "parentName": ""
    }
  ]
}
```
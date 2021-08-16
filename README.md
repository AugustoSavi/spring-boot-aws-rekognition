# Spring Boot Application to demonstrate AWS Rekognition

![](https://img.shields.io/github/issues/AugustoSavi/spring-boot-aws-rekognition?style=for-the-badge)
![](https://img.shields.io/github/forks/AugustoSavi/spring-boot-aws-rekognition?style=for-the-badge)
![](https://img.shields.io/github/stars/AugustoSavi/spring-boot-aws-rekognition?style=for-the-badge)
![](https://img.shields.io/github/license/AugustoSavi/spring-boot-aws-rekognition?style=for-the-badge)
![](https://img.shields.io/twitter/url?url=https%3A%2F%2Fgithub.com%2FAugustoSavi%2Fspring-boot-aws-rekognition?style=for-the-badge)
<br/>
[![CodeQL](https://github.com/AugustoSavi/spring-boot-aws-rekognition/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/AugustoSavi/spring-boot-aws-rekognition/actions/workflows/codeql-analysis.yml)
[![Java CI with Maven](https://github.com/AugustoSavi/spring-boot-aws-rekognition/actions/workflows/maven.yml/badge.svg)](https://github.com/AugustoSavi/spring-boot-aws-rekognition/actions/workflows/maven.yml)
## Como Usar?

```bash
# Clone o repositório
$ git clone https://github.com/AugustoSavi/spring-boot-aws-rekognition.git

# Entre no repositório
$ cd spring-boot-aws-rekognition

# renomeie o arquivo application.yml para application.yml
# coloque as informações no application.yml

# abra um novo terminal e execute
$ mvn spring-boot:run
```

## Imagem usado no exemplo
![naoemaconha](https://user-images.githubusercontent.com/32443720/129457710-daadf2f6-f6d1-42ad-aae9-730768d23e4b.jpg)

## envio
    Atualmente esse serviço consome a fila de um rabbitmq que tem como modelo de mensagem: 
```java
public class ImagemAdicionadaEvent {
    private String id;

    private String bucketName;

    private String url;

    private String keyFile;

    private StatusProcessamento status;
}
```

### retorno 
```json
{
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
## Desenvolvedores

[<img src="https://avatars.githubusercontent.com/u/32443720?v=4" width=115 > <br> <sub> Augusto Savi </sub>](https://github.com/AugustoSavi) | [<img src="https://avatars.githubusercontent.com/u/26530455?v=4" width=115 > <br> <sub> Jeanluca Fernandes </sub>](https://github.com/Jean1dev/) |  
| :---: | :---: |
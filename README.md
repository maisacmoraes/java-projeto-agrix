# Agrix - Sistema de Gestão e Monitoramento de Fazendas

O Agrix é um sistema desenvolvido em Java que permite a gestão e o monitoramento de fazendas participantes. Este projeto demonstra a aplicação de diversos conceitos e tecnologias do ecossistema Spring para criar uma API robusta e segura.

## Funcionalidades

- Gestão de fazendas: Cadastre, atualize e remova informações sobre fazendas.
- Monitoramento: Acompanhe dados importantes sobre as fazendas.
- Autenticação: Use o Spring Security para garantir que apenas usuários autorizados tenham acesso ao sistema.
- Autorização: Defina diferentes níveis de autorização para garantir que cada rota atenda a regras específicas de segurança.

## Tecnologias Utilizadas

- **Spring Boot**: Facilita a criação de aplicações Java autônomas e com configurações mínimas.
- **Spring Web**: Crie rotas da API de forma simples e eficaz.
- **Spring Data JPA**: Implemente entidades e repositórios para a persistência em banco de dados de forma eficiente.
- **Spring Security**: Adicione autenticação ao projeto e defina regras de autorização.
- **Docker**: Configure a aplicação para execução em containers Docker.
- **JUnit**: Desenvolva testes unitários para garantir a qualidade do código.

## Iniciando

Certifique-se de ter o Docker instalado para simplificar a execução do Agrix.

### Executando com Docker

1. Clone este repositório:

```
git clone https://github.com/seu-usuario/agrix.git
cd agrix
```

2. Construa a imagem Docker:
```
docker build -t agrix .
```

3. Execute o contêiner Docker:
```
docker run -p 8080:8080 agrix
```

Agora, o Agrix estará disponível em http://localhost:8080.

Configurações
Antes de executar o projeto, você pode configurar as propriedades do banco de dados em application.properties para atender às suas necessidades.

Testes
Certifique-se de que o projeto esteja em execução e execute os testes unitários para garantir que tudo funcione conforme o esperado:
```
./mvnw test
```

### Contribuindo
Sinta-se à vontade para contribuir com melhorias ou correções para o Agrix. Crie uma solicitação de pull com suas alterações e descreva-as detalhadamente.

### Licença
Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para obter detalhes.

Nota: Este é um projeto fictício criado apenas para fins de demonstração e aprendizado. Não se destina a ser usado em produção, mas sim como um exemplo de como aplicar tecnologias Spring em um projeto Java.

# Contratual - Sistema de Controle de Contratos

Pequeno projeto que criei em 2018 para estudar Spring Framework.

Depende de conexão com banco de dados MySQL.

## Quick start
Edite as configurações de banco de dados no arquivo ./src/main/resources/application.properties conforme abaixo, substituindo <> pela config correta:

``` properties
spring.datasource.url=jdbc:mysql://<host_db>/contrato?createDatabaseIfNotExist=true&storage_engine=InnoDB&serverTimezone=America/Sao_Paulo
spring.datasource.username=<usuario_bd>
spring.datasource.password=<senha_usuario_bd>
```
Para iniciar a aplicação, execute no shell:

``` sh
$ mvn spring-boot:run
```
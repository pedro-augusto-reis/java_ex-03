#### Objetivo
Este projeto tem como objetivo exemplificar configurações básicas que sirvam de modelo para outros projetos.  
Neste projeto, as seguintes características foram buscadas:
1. Spring-Boot;  
    * O modelo deve ser capaz de utilizar o Spring Boot para ambiente de desenvolvimento, e para ambiente de produção, 
gerar um pacote .war para ser implantado no servidor de aplicação JBoss 6.4; 
2. Autenticação dos serviços por meio da ferramenta KeyCloak;
3. Estrutura que atenda a arquitetura de Microserviços;  
   * Camada MVC apenas para exemplificar as funcionalidades de serviço;  
   * Utilização de ferramentas do Spring Cloud + Netflix OSS que apoiem a arquitetura;
4. Implementação de Logs;
5. Spring JPA;
6. Maven;

#### Iniciar a aplicação
1. Para iniciar em ambiente de desenvolvimento, com o Tomcat do Spring Boot:
    * iniciar normalmente:
        * **mvn spring-boot:run -Plocal -Dspring.profiles.active=local** 
    * debug: 
        * **mvn spring-boot:run -Dspring.profiles.active=jboss -Plocal -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=INFORMAR_PORTA"**
2. Para gerar o .war para ambiente de produção:
    * **mvn clean install**
3. URL: localhost:8080/modeloArquiteturaSpring/login

#### Arquivos criados
1. Arquivos de configuração  
    * [pom](pom.xml) - maven
    * [jboss-web](src/main/webapp/WEB-INF/jboss-web.xml) - jboss
    * [jboss-deployment-structure](src/main/webapp/WEB-INF/jboss-deployment-structure.xml) - jboss
    * [application](src/main/resources/application.properties) - spring
2. Arquivos Java
    * [KeycloakSecurityExemplo](src/main/java/com/http418/KeycloakSecurityExemplo.java) - classe principal spring
    * [LoginControle](src/main/java/com/http418/controle/LoginControle.java) - teste serviço
    * [ExemploEndPoint](src/main/java/com/http418/rest/ExemploEndPoint.java) - serviços
    * [KeycloakSecurityConfigurer](src/main/java/com/http418/seguranca/KeycloakSecurityConfigurer.java) - segurança keycloak
    * [LoginServico](src/main/java/com/http418/servico/LoginServico.java) - teste serviço
3. Arquivos JSP
    * [login](src/main/webapp/WEB-INF/jsp/login.jsp) - teste serviço
    * [welcome](src/main/webapp/WEB-INF/jsp/welcome.jsp) - teste serviço

#### Fontes
1. [spring-boot-with-keycloak](https://sandor-nemeth.github.io/java/spring/2017/06/15/spring-boot-with-keycloak.html)
2. Jboss
    * [jboss-web.xml](https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/6.4/html/security_guide/jboss-webxml_configuration_reference)
    * [Ajuste Jboss JPA](https://programmingthoughtworkbysrinivasan.blogspot.com.br/2017/04/spring-152-with-jpa-21-integration-with.html)
3. Spring
    * [Documentacao Spring 01](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging)
    * [Documentacao Spring 02](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#howto-create-a-deployable-war-file)
    * [Documentacao Spring 03](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
    * [Blog MkYong](https://www.mkyong.com/spring-boot/spring-boot-hello-world-example-jsp/)
    * [Maven Plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/index.html)
    * [Parâmetros application.properties](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)
    * [Multiple application.properties](https://emmanuelneri.com.br/2017/05/14/profiles-no-spring-boot/)
    * [Implementação JPA](http://scrumbucket.org/tutorials/mongodb-spring-data-queries/part-2-setting-up-some-spring-queries/)
    * Anotações
        * [@Repository](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Repository.html)
        * [@Service](https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/stereotype/Service.html)
        * [@Autowired](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html)
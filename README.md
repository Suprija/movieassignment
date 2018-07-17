 MOVIE TICKET BOOKING 


PREREQUISITES:

Java JRE, Tomcat, MySQL database.

INSTALLING :

Creating database:
create database if not exists <database_name>;


Creating user in mysql :
create user '<mysql_username>'@'localhost' identified by '<mysql_userpasword>';
grant all on <database_name>.* to '<mysql_username>'@'localhost';

application.properties file:
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name>
spring.datasource.username=<mysql_username>
spring.datasource.password=<mysql_userpasword>
spring.mvc.view.prefix: /
spring.mvc.view.suffix: .jsp
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.messages.basename=validation
server.error.whitelabel.enabled=false


If there exist any tables by the name 'user','info','profile', please delete them using the command :

drop table < name of the table >;




Deploy the war file to Tomcat.

If your tomcat is configured to be on 8080, you can access the app using:

Starting url:
	localhost:8080/{name of war file}/registration

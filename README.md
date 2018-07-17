 MOVIE TICKET BOOKING 


PREREQUISITES:

Java JRE, Tomcat, MySQL database.

CONFIGURING mysql :

mysql -u root -p

Creating database:
create database if not exists <database_name>;


Creating user in mysql :<br>
create user '<mysql_username>'@'localhost' identified by '<mysql_userpasword>';<br>
grant all on <database_name>.* to '<mysql_username>'@'localhost';<br><br>

exit and login as created mysql user :<br>
mysql -u <mysql_username> -p<br><br>

Now enter your mysql_userpassword<br><br>

Use your created database :<br>
use <database_name>;<br><br>

application.properties file:<br>
spring.datasource.url=jdbc:mysql://localhost:3306/<database_name><br>
spring.datasource.username=<mysql_username><br>
spring.datasource.password=<mysql_userpasword><br>
spring.mvc.view.prefix: /<br>
spring.mvc.view.suffix: .jsp<br>
spring.jpa.hibernate.ddl-auto=update<br>
spring.jpa.show-sql=true<br>
spring.messages.basename=validation<br>
server.error.whitelabel.enabled=false<br>


If there exist any tables by the name 'user','info','profile', please delete them using the command :

drop table < name of the table >;




Deploy the war file to Tomcat.

If your tomcat is configured to be on 8080, you can access the app using:

Starting url:
	localhost:8080/{name of war file}/registration

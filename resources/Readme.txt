https://github.com/mallisevenhills/security.git

1. Need to install Java,Tomcat,Mysql,maven
2. Need to run the script which is under "resources/sql/db_shema.sql"
3. We can down load it/checkout from github .
4. After down loaded then run the "mvn clean install" command
5. Copy the war file under tomcat and start the server
6. Once server started we can see "Sign Up" and "Sign In" Option
7. Register  with user name and password , by default it will create "role" as "ADMIN".
  So I gave the access for "ADMIN" role.
  If you want change your role to "USER, VISITOR", directly on DB  and click on the "Get Details" option ,
  it will through to login page .
  
8. Sign in with your credentials , once you loggedin successfully , then you can see "Get Details" option
if your role is "ADMIN" then only it will allow for for getting the user details , Other wise it will through to login page again

9. If your credentials not valid then also it will through to login page 
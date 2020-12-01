JSPForum Project v0.1 (Eng.)
-----------------------------

Introduction
-------------
This first package released with two main folders, 'forum' dan 'WEB-INF'. Forum contains all jsps files that act as front end interface to users while WEB-INF contains Servlet and JavaBean files that act as processor dan response component.

This project implements JSP-Servlet-JSP archirtecture that purpose for increase information processing security where all process for store and response information handle by Servlet. A usage of session also been use for a same purpose. A usage of URL Rewriting had been decrease for avoid from end users hack the system.

There's contains a few folders in forum:

1. templates - contains jsp and CSS files for end user customization.

2. jsps - contains jsp files that response all request from user and invoke processes to the Servlet.

3. engines - contains jsp files that generate all forums information from the database.

How to Install
---------------
This project had been developed and tested with OrionServer Web Application (http://www.orionserver.com). For installation, firstly, you must install Orion Web Server itself. For good performance, use Jikes compiler with it. Then, copy both two folder to 'default-web-app' folder and replace everything. So, that's all for application installation.

For install the database, you can use anything kind of database such as MS Access, PostgreSQL or MySQL. It depends to you. And then, develop the database tables exactly like a tables in MS Access database that I attach in this package that named forum.mdb. After that, edit file name WEB-INF/classes/forum/bean/DBConnection.java for matched the system with a database that you used. And that's all for the database application.

Lastly, compile all file thats extention with *.java ; javac *.java; in both WEB-INF/classes/forum and WEB-INF/classes/forum/bean folders. (Remember, don't forget to set CLASSPATH before you compile those files; SET CLASSPATH=C:\JDK13~1.1\SRC.JAR;C:\ORION\ORION.JAR;C:\orion\defaul~1\WEB-INF\classes).

And then, it's ready to run and be test. Run Orion for start the application.

Good Luck.
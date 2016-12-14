# AgentryJavaTools

The goal of this tutorial is help you get a general understanding of how to use a Java Back End with an Agentry application.
To get the most our of this tutorial you will need a basic understanding of the Java programming language or similar language such as C++, C#, or Delphi/Object Pascal.

For some more basic introduction to the Java language, check out the following tutorials:
From the Oracle site http://docs.oracle.com/javase/tutorial/index.html
I recommend reviewing at least the following sections:
1. The basics of Hello World at
http://docs.oracle.com/javase/tutorial/getStarted/application/index.html
2. Learning the Java Language
http://docs.oracle.com/javase/tutorial/java/index.html 
These topics provide Good overall basic coverage of Java.  
(The Generics section is a little more advanced.  You should understand Generics well enough to use classes implemented with Generics, but you may not need to implement new Generic classes.)
3. Collections
http://docs.oracle.com/javase/tutorial/collections/index.html
Collections is a slightly more advance topic, but very useful.


Typically an Agentry Java Backend is used to connect to an Enterprise system that provides an API for Java connectivity.
For example, Agentry based products use a Java Backend to communicate with Maximo and SAP systems.
In a real world use of an Agentry Java backend, these Enterprise systems are responsible for the long term storage.
The Agentry server and its Java (or other type of) backend simply passes relevant data between the Enterprise system and the user's mobile device.

This example uses some simple Java classes to store the "backend" data in order to eliminate the need to setup and work with an Enterprise system.
The ToolRepository class serves as our simple simulated in-memory backend.  It allows the application data to be updated for as long as the Agentry server is running.
The source for our Workmanager product provides examples of how to work with SAP and Maximo backends.
This example project is structured in a similar fashion as the Java Backends in our products.  So your understanding of this example will be transferable to working with our other Java Backends.

Note classes in the com.syclo.java package implement general functionality needed by a Java back end to interface with the Agentry Server.
Typically classes for connecting your enterprise backend system already exist and can be used instead of written.
The provided com.syclo.java classes parallel classes in com.syclo.sap and com.syclo.maximomobile which implement round trip connectivity to SAP and Maximo systems respectively.
The classes in the com.syclo.tool and below are classes specific this Tools project implementation.
Most likely you will be writing classes like those in com.syclo.tool in order to configure Agentry access to your particular data.
Notice that the tool classes generally extend classes from the java package to take advantage of the existing functionality an minimize the amount of Java needed to support custom data.

This example implements java access to all three types of data found in an Agentry application.
DTColor is an example of an Agentry DataTable.  DataTables are limited to key/value pairs that are read from the backend and not changed on the mobile client.
CTStoreRoom is an example of an Agentry ComplexTable.  ComplexTables support reading of larger tables of data with many fields. 
Tool is an example of working with an Agentry Object.  Agentry Object are used for data items that may need to be updated on the mobile client.
CRUD (Create, Read, Update, and Delete) support for Tool is implemented in this application as follows:
  Read: 	Agentry ToolsGet Fetch's server exchange step -> ToolsGetSteplet -> ToolsGetStepHandler
  Create: 	Agentry AddTool transacation's update step -> ToolAddSteplet -> ToolAddStepHandler
  Delete:	Agentry DeleteTool transacation's update step -> ToolDeleteSteplet -> ToolDeleteStepHandler
  Update:	Agentry EditTool transacation's update step -> ToolEditSteplet -> ToolEditStepHandler
Notice that all these transactions work with a Tool POJO (Plain Old Java Object) with Public fields.  
The Agentry server automatically maps the public POJO fields with the Agentry Object properties while fetching as long as both names match.
For mapping fields for transactions, the Agentry API provides access via calls like getString("transaction.toolnum")
The Agentry API also provides access to addition data from the client via other Syclo Data Markup Language tags which are documented in the Agentry Language Reference manual.

Recommended next steps for working this this tutorial.
1. Complete installation of the Agentry Server and test client so you can see this application in action.
2. Review the provided JavaDocs for an overview of the included code.
3. Review any classes of particular interest.
4. Set breakpoints in classes of interest to examine the dynamic behavior of this code.


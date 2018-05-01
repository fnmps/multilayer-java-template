# multilayer-template
An example of a maven project following a multilayer architecture.

*Note that this application is simply a mock to exemplify the use of each layer and how to separate each layer using maven project dependencies.
It should not be considered as an actual application.

<img src="https://github.com/fnmps/multilayer-java-template/blob/master/multilayer-template/Documentation/images/example-architecture.png"/>

This example is a simple functional application that shows relationships between different users.

The application consists of 2 main modules a authentication module and a relationships module. 

The authentication module of the application provides the way a user might be authenticated.

The relationships module of the application provides the services that allow to fetch/add/update/remove relationships between users.


<img src="https://github.com/fnmps/multilayer-java-template/blob/master/multilayer-template/Documentation/images/example-architecture-dependencies.png" />


### Data Access Layer
On this example we have a data access layer which contains 2 entities, the user account, that contains the information about the user, and the relationships entity, which contains the information regarding the relationships between each user.

### Business Layer


### Service Layer


### Presentation Layer
On this example we have a presentation layer that consists of 2 screens using JavaServer Faces framework.
For the login screen we use the authentication server to check if a user exists.
For the relationships screen, we use the relationships module to 


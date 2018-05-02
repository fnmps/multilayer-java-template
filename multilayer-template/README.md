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

### Service Layer
The service layer provides two interfaces for each module. 

For the authentication module we provide an API with simple operations to allow the consumer to authenticate a user by its username.

For the relationships module beside a simple API with operations for fetching relationships, we also provide the same API with a SOAP service. They expose the same functionality but while with the SOAP service we have a single operation that allows to fetch all types of relationships in a single call (typical implementation of a SOAP service) on the non web service API we separate the fetching of different types of relationships in different operations, simply because we do not need to worry about the network overhead of calling a webservice.

### Business Layer
The business layer, just like the service layer, is separeted into 2 separate modules. 

Both modules contain a facade that implement each of the services of their respective modules.

On the relationships module we use the same facade to implement both the non web service interface and the SOAP interface. On the first case, we have a business function for each of the operation, but for the second case we simply separate the input of the SOAP operation and call the appropriate business functions depending on the input received and aggregate the output of each of the business functions into the ouput of the SOAP operation.

With this design we are able to conceal the service layer from the business functions, being that the business functions do not care if the call was made via SOAP, REST or any other kind of call. It is the facade's responsibility to map the input coming from the consumer into an input that the business functions understand and to call the right business functions.

(Note that we separate the facade and the rest of the business layer maven modules so that we can clearly separate the dependencies between the business functions from the service functions, i.e., the business functions should not be dependent on the functions that the service provides).

### Presentation Layer
On this example we have a presentation layer that consists of 2 screens using JavaServer Faces framework.

For the login screen we use the authentication server to check if a user exists.

For the relationships screen, we use the relationships module to fetch all the infromation we need to show the user the relationships that he has. 


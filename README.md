# multilayer-java-template
An overview of a multilayer architecture.

<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/multilayer.png" width="450"/>

A multilayered architecture is a client–server architecture in which presentation, application processing, and data management functions are conceptually separated.

By segregating an application into layers, developers acquire the option of modifying or adding functionality to a specific layer, instead of reworking the entire application.


<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/presentationlayer.png" width="450"/>

This is the topmost level of the application.

The presentation layer displays information to the user.

It communicates with the service layer by which it puts out the results to the browser/client. 

In simple terms, it is a layer which users can access directly.

A typical pattern used on this layer is the model-view-controller.


<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/mvc.png" width="450"/>

Model-View-Controller (MVC)
The MVC software design pattern has as main objective to be able to easily separate the responsibilities of each part of the design.
The three distinct parts are:

The Model: Responsible for managing the data that will be shown the user.

The View: Responsible for the output representation of the application. Usually consists of the html files of the project.

The Controller: Processes the requests from the user and reacts accordingly. Beside being responsible for the UI logic of the application (when and what is shown to the user) it calls the services exposed by the lower layer mapping the model into the objects that are accepted by the service layer. 


<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/servicelayer.png" width="450"/>

The service layer abstracts the business functions, hiding the implementation details of the business layer.

It serves to expose only the necessary functionalities of the business layer to the outside (e.g., presentation layer and external services).

Usually only composed by lightweight classes and interfaces that are needed for the outside world to communicate with the core of the application.



<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/servicelayer-flow.png" width="450"/>

This layer define functionalities that should be exposed as interfaces – for the presentation layer of the application – or as web services – for any external application that wants to communicate with our application.

The service layer has no knowledge of the outside layers. It only defines the contract that the business layer will implement and that is visible to the presentation layer or external applications.


<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/servicelayer-content.png" width="450"/>

A service is usually only composed of 3 parts: the model, the exceptions, and the interface.

The interface consists of the functions that the business expose to the outside.

The model consists of the various classes that the interface receives and outputs (DTOs for interfaces and input/output messages for webservices).

The exceptions, much like the model, consist of the various exceptions that each function can throw.

<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/businesslayer.png" width="450"/>


This layer implements the core functionality of the system, and encapsulates the relevant business logic and rules of the application.

It also prescribes how business objects interact with one another and enforces the routes and the methods by which business objects are accessed and updated.


<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/businesslayer-flow.png" width="450"/>

Usually on the business layer we use the façade pattern.

The façade is responsible for implementing the contracts defined on the service layer

The façade does not implement business logic. It simple maps the service input and output and calls  proper business functions that cover the business logic/rule for that call.

<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/businesslayer-modules.png" />

The business functions do not care if the caller is a web service or a plain interface, it’s the responsibility of the façade to abstract it. (i.e., business functions are not aware of the model/exceptions/interface of the service layer)

A lot of times the business layer is divided into multiple modules, different business components, different modules. 
On these cases each module would then have its own façade and business functions.

<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/businesslayer-adapters.png" width="450"/>

Sometimes business function requires the call of functions outside of their module.

For this, we use adapters.

This adapters are similar to the façade. They map the input/output of the function/service and business objects.

An adapter should also supply to the business functions an appropriate abstraction of the service/function being called.

Example, supposed there is a service that provides all the information about a user (getUserData), however, the business rules only require a piece of that information (e.g., the birthdate of the user).

The adapter should then provide a function getNameOfUser that will call getUserData, but only returns the appropriate data to the business function.


<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/dataaccesslayer.png" width="450"/>

The Data access layer provides simplified access to data stored in persistent storage.

This layer connects to the database and performs the actual operations required by the application.

On this layer a single method can translate into multiple instructions that the database understands using a repository pattern or DAO pattern.



<img src="https://github.com/fnmps/multilayer-java-template/blob/master/docs/images/dataaccesslayer-flow.png" width="450"/>

The business layer is conscious of the entities and repositories that exist on the data access layer. 

The business functions are responsible for mapping the domain objects into entities and calling the correct repositories.

The repositories offer an abstraction that allows the business layer to interact with the different databases and tables that the application needs to interact.

A single repository can execute statements that affect multiple entities/tables of one database.

# CVC API-Project

API Rest Grupo CVC 

Broker coded with Java Spring Boot and frontend with Vue.js


### Prerequisites

* [Java 8](https://www.java.com/pt_BR/download/) - Development Kit 
* [Spring Tools 4 for Eclipse](https://spring.io/tools) - IDE for Development
* [Git](https://git-scm.com/downloads) - Open source distributed version control system
* [NodeJS](https://nodejs.org) - JavaScript runtime built on Chrome's V8 JavaScript engine
* [Vue CLI 3](https://cli.vuejs.org) - Standard Tooling for Vue.js Development
* [VSCode](https://code.visualstudio.com) - Lightweight source code editor for client-side (Not mandatory)

### Installing

Checkout the code from Github repository inside Eclipse Workspace 
```
$ git clone https://github.com/lordssa/cvc-fullstack-solution.git
$ npm install 
```

After acquire the project, open the Eclipse and select the option "import existing Maven projects" in "File > Import"

Once you have maven installed on your environment, install the project dependencies via:

```
mvn install
```

## Running

Once you have installed dependencies, this can be run from the `CvcProjectApplication.java` main method directly,
or from a command line:
```
mvn spring-boot:run
```

The API will be available at http://localhost:8080/api/ 


To run the client side, run the command below
```
npm run serve
```
Open your browser and go to http://localhost:8081 and you should see the results


### Accessing API documentation

After server up, access http://localhost:8080/swagger-ui.html. On the sale-controller contains a list of API services, parameters and output sample. 

### Trying out

Through Swagger.
```
*Example*
On the section sale-controller, select method GET "/api/hoteis/detalhes" and click "try it out" button, fill the required parameters, click in execute button and that's it!
```
## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger 2](https://swagger.io/) - Documentation and User Interface for the REST Service
* [Vue.js](https://vuejs.org/) - Progressive Javascript Framework for building UI on the web

## Authors

* **Cid Soares** - *Initial work* 



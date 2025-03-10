# Insurance Management Application

## Overview
This project is a fullstack application for an insurance company, built with a ReactJS frontend and a Spring Boot-based microservices backend. The system allows complete management of clients and their insurance policies (automobile, home, health) through intuitive user interfaces supported by REST APIs.

## Services

### Customer Service
Manages client information.

#### Main Entities
- **Client**: `id`, `nom`, `prénom`, `email`, `adresse`, `téléphone`, `userId`

#### Features
- Add a client
- List clients
- Search for a client by ID

### Policy Service
Manages insurance policies and claims.

#### Main Entities
- **Contrat**: `id`, `type` (AUTO/HABITATION/SANTÉ), `dateEffet`, `dateExpiration`, `montantCouverture`, `clientId`
- **Sinistre**: `id`, `date`, `description`, `montantRéclamé`, `montantRemboursé`, `contratId`

#### Features
- Create an insurance policy
- Declare a claim
- View a policy
- List policies of a client
- List claims by policy

### Gateway Service
Acts as a single entry point API using Spring Cloud Gateway.

### Discovery Service
Service discovery using Eureka.

### Config Service
Centralized configuration management.

### Auth Service
Handles user authentication and management using JWT.

#### Main Entities
- **User**: `id`, `login` (String), `password` (String), `active` (Boolean), `role` (Role)
- **Role**: `name` (ADMIN, CLIENT)

#### Features
- User registration
- Authentication (login/logout)
- JWT token management
- Role and permission management

## Project Structure
- `customer-service`: Contains the Customer Service code and configuration.
- `policy-service`: Contains the Policy Service code and configuration.
- `gateway-service`: Contains the Gateway Service code and configuration.
- `discovery-service`: Contains the Discovery Service code and configuration.
- `config-service`: Contains the Config Service code and configuration.
- `auth-service`: Contains the Auth Service code and configuration.

## Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Docker

## Building the Project
To build the project, run the following command in the root directory:
```sh
mvn clean install
```

## Running the Services
To run the services, navigate to the respective service directory and run the following command:
```sh
mvn spring-boot:run
```

## Accessing the Services
- **Discovery Service**: [http://localhost:8761](http://localhost:8761)
- **Gateway Service**: [http://localhost:8080](http://localhost:8080)
- **Auth Service**: [http://localhost:8081](http://localhost:8081)
- **Customer Service**: [http://localhost:8082](http://localhost:8082)
- **Policy Service**: [http://localhost:8083](http://localhost:8083)

## Configuration Files
- `discovery-service/src/main/resources/application.yml`: Configuration for the Discovery Service.
- `auth-service.iml`: IntelliJ IDEA module configuration for the Auth Service.

## Frontend
The frontend is developed as a Single Page Application using React.js.

### Features
- Client management
- Insurance policy management
- Claim declaration and tracking
- Form validation and error display
- User authentication and session management

### Technologies
- React.js
- React Router for navigation
- Axios for API calls
- Design framework of your choice (e.g., Material-UI, Styled-components)

## Planning

Jira is used for planning and tracking the progress of this project. You can view Jira board [here](https://meskinemsoatafa.atlassian.net/jira/software/projects/SMAR/boards/87/backlog).

## Authors

For any questions or feedback, please contact The author of this project:

- **Asmaa Barj**
    - Email: asmaabarj5@gmail.com
    - GitHub: [Asmaa Barj](https://github.com/asmaabarj).

- **Yassine Hanach**
    - Email: yassinedubraska@gmail.com
    - GitHub: [Yassine Hanach](https://github.com/Yassinean).

- **Meskine Mostafa**
    - Email: meskinemostafa4@gmail.com
    - GitHub: [Meskine Mostafa](https://github.com/MesVortex).
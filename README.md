# Bookish

### Team Members 
  - **Tylar Gossett**
  - **Prince Patel**
  - **Sami Mohammad**

## Business Requirements

### Vision

An App Where you can post book recommendation.

### Mission

Make a user friendly and simple app to share book recommendation.

#### Core User

Enthusiastic Bookworms


## How to Run

### 1. Start Docker Database Container

> **Note:** This is only needed if you are using the MariaDB launch configuration (providing the mariadb profile via active profiles).

Make sure Docker Desktop is running and your database container is active. `Bookish` requires a datasource connection to start.

**Use Docker Compose**
- Navigate to `/src/main/java/com/winsupply/bookish/db`
- Run `docker-compose up`

### Run the Application

Ensure that you are using the expected launch configuration in Visual Studio Code. You can do this by going to the Run And Debug View (play button with a bug in the bottom left corner) in the left sidebar menu, or by using the menu bar clicking View -> Open View -> Run And Debug.

> **Note:** There are multiple launch configurations defined, and the default is the H2 database. H2 runs in-memory and doesn't currently get instantiated with data. If you are trying to connect to the MariaDB database, ensure that you select that launch configuration since it does include data.

1. From the Run And Debug View

- When in the Run And Debug View, you can click the play button next to the selected configuration dropdown. This will launch the program into the debugger unless noDebug option is specified in the launch configuration.

2. Context Menu In The Explorer View

- If you right click on a file in the Explorer View, the context menu will list "Run Java" and "Debug Java". Either will work, and they will use the first defined profile in the launch configuration.

3. Gradle Command

- You can also use the included Gradle binary in the repo to run the application. Since you should be running this in Linux or Unix environment, the following command will be what you want to run from the main folder of the project where the gradlew file is located.

```bash
./gradlew bootRun --args="--spring.profiles.active=mariadb"
```

> ***Note:*** The active profile specified in the command above is tied to profiles defined in the application. Currently, the options are: "h2" and "mariadb", which are for switching between database providers.


### 3. Verify with Bruno

1. Open Bruno and click "Open Collection"
2. Select the folder: `/bookish/Bruno/Bookish`

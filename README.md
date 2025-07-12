# HelloWorld Servlet Project

## Project Structure
Create the following directory structure in your IntelliJ project:

```
hello-servlet/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── servlet/
│       │               └── HelloWorldServlet.java
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml
│           └── index.html
```

## Setup Instructions

### 1. Create New Project in IntelliJ
1. Open IntelliJ IDEA
2. File → New → Project
3. Select "Maven" from the left panel
4. Check "Create from archetype"
5. Select "maven-archetype-webapp"
6. Click Next

### 2. Configure Project Details
- **GroupId**: `com.example`
- **ArtifactId**: `hello-servlet`
- **Version**: `1.0-SNAPSHOT`
- Click Next, then Finish

### 3. Replace Generated Files
Replace the generated `pom.xml` with the provided one, then create the directory structure and add the files as shown above.

### 4. Configure Tomcat Server
1. Go to Run → Edit Configurations
2. Click "+" and select "Tomcat Server" → "Local"
3. In the "Server" tab:
   - Name: "Tomcat Local"
   - Application server: Point to your Tomcat installation
4. In the "Deployment" tab:
   - Click "+" → "Artifact"
   - Select "hello-servlet:war exploded"
   - Set Application context to "/hello-servlet"
5. Click OK

### 5. Run the Application
1. Click the green play button or press Shift+F10
2. Your browser should open automatically
3. Navigate to: `http://localhost:8080/hello-servlet`

## Testing the Servlet
- Main page: `http://localhost:8080/hello-servlet/`
- Servlet endpoint 1: `http://localhost:8080/hello-servlet/hello`
- Servlet endpoint 2: `http://localhost:8080/hello-servlet/hello-world`

## Troubleshooting

### If Tomcat is not available:
1. Download Apache Tomcat 9.x from https://tomcat.apache.org/
2. Extract it to a directory (e.g., `C:\apache-tomcat-9.0.x`)
3. In IntelliJ, go to File → Settings → Build, Execution, Deployment → Application Servers
4. Click "+" and select "Tomcat Server"
5. Point to your Tomcat installation directory

### If the servlet doesn't load:
1. Check that the project builds successfully (Build → Build Project)
2. Verify the servlet annotation `@WebServlet` is properly configured
3. Check the Tomcat logs in the IntelliJ console for any errors

## Features of the HelloWorld Servlet
- Responds to both GET and POST requests
- Displays server time, client IP, and request information
- Uses HTML styling for a clean presentation
- Handles multiple URL patterns (`/hello` and `/hello-world`)
- Includes proper error handling and resource cleanup

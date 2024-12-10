# **How to Run the Automation Tests**

**Prerequisites:**
Java Development Kit (JDK): Ensure JDK 8 or above is installed on your system.
Eclipse IDE: Install Eclipse IDE with the TestNG plugin.
Maven: Ensure Apache Maven is installed and configured in your system's PATH.

**Steps to Execute Tests**

**1. Clone the repository:**
git clone https://github.com/your-repo/OneComics.git

**2. Open the project in Eclipse:**
Go to File > Import > Existing Maven Projects.
Navigate to the cloned repository directory and select the pom.xml file.

**3. Configure the project:**
Right-click on the project in the Package Explorer.
Select Maven > Update Project to ensure all dependencies are resolved.

**4. Run the tests:**
**In Eclipse, navigate to the suiteFiles directory.
Right-click on AllSuite.xml and select Run As > TestNG Suite.**

**5. Generating Test Reports:**
After execution, detailed reports will be generated in the test-output directory.
Open the emailable-report.html file in your browser to view the TestNG report.

# **Key Features**

Page Object Model (POM):
All UI interactions are abstracted into page classes located under com.onecomics.webpages.

Reusable Methods:
Utility methods for common actions are defined in com.onecomics.projectmethods.ProjectMethods.

TestNG Integration:
Tests are organized and executed using TestNG with AllSuite.xml.

Configuration Management:
Centralized configuration in config.properties.

Modular Design:
Clear separation of test cases, page objects, and utilities for better maintainability.

# **Tools and Technologies**
Language: Java
Framework: Selenium WebDriver, TestNG
Build Tool: Maven
IDE: Eclipse
Reporting: TestNG Reports

# **Notes**
Ensure the WebDriver binaries (e.g., ChromeDriver, GeckoDriver) are correctly set up in the system's PATH or specified in the BaseClass.java file.
The framework is modular and can be extended to include more test cases, browsers, and configurations.

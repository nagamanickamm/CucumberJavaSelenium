# CucumberJavaSelenium
Using AutomationPractice.com

Code Structure:
1. Cucumber Feature files are placed under test.java.resources.features
2. Cucumber Step definition file is placed under test.java.com.test.naga package
3. Page files are java.com.test.naga.pages package
4. Main driver initialisation java.com.test.naga.utils.driver package
5. Common driver functions initialisation java.com.test.naga.utils.common package


Setup & test:
1. Install Gradle on your machine https://gradle.org/install/
2. Download remote repository git@github.com:nagamanickamm/CucumberJavaSelenium.git 
3. Open the project using your choice of IDE (Note: This project is build using IntelliJ)
4. Go to Terminal and enter "gradle --refresh-dependencies" (without quotes)
5. type "gradle cucumber -Pbrowser=firefox" (change your browser accordingly)
6. When the test is a completed click on the cucumber report link shown in the terminal 
   or go to https://reports.cucumber.io/report-collections/ece07264-f966-43d8-8e1d-b39b14c7f1e1
7. Alternatively you can execute from run command in intelliJ or any iDE, please add -Dbrowser=firefox in VM options
8. If you have any issues with browser parameter then please comment systemProperties['browser'] = browser in build.gradle and it should take from properties file
Notes:
- Sample report can be found in report/Cucumber Reports.pdf or
- Cloud report sample - https://reports.cucumber.io/report-collections/ece07264-f966-43d8-8e1d-b39b14c7f1e1


Further enhancements:
1. Additional reporting plugins such as Allure, extent, cucumber report plugins cab be added depending on need
2. Further, cloud based AI reporting can be added using ReportPortal IO
3. CI CD can be setup easily with gradle options
4. Environment config file can be further enhanced to switch between multiple environments
5. Passwords can be set using secret key such as in Jenkins configurations
6. Use API calls to generate Test Data
7. Use Example option on cucumber to add Data driven test
8. Add @<tag> annotations to run only selected area of features
9. Add more validations for each page (Due to time constraint I could not validate every element)
10. Enable Parallel runs across test and browser
12. Crossbrowser platforms such as Selenoid, Saucelabs, Browserstacks can be added

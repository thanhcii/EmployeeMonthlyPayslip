# EmployeeMonthlyPayslip
SOFTWARE RECOMMENDED <br>
- Eclipse IDE for Enterprise Java and Web Developers - 2021-06 <br>
https://www.eclipse.org/downloads/packages/release/kepler/sr1/eclipse-ide-java-developers <br>
- Spring tool 4 (aka Spring Tool Suite 4) <br>
https://spring.io/tools <br>
- Java jdk 11 <br>
https://www.oracle.com/java/technologies/javase-jdk11-downloads.html <br>
<br>

**************************************************************

DOWNLOAD AND SETTING THE WORKPLACE <br>
TWO options to run: <br>
*** Option 1 *** <br>
Add a local project <br>
- Download as ZIP full source code at github <br>
Code -> Download as ZIP to folder (Default: C:\Java Download\
https://github.com/thanhcii/EmployeeMonthlyPayslip <br>
- UNZIP EmployeeMonthlyPayslip-main to folder (Default: C:\Employee\)
- Launch Eclipse IDE -> Add a local project 
- Project path: Choose your source code path that you have just unzip to (Default: C:\Employee\EmployeeMonthlyPayslip-main\spring-boot-import-csv-file-app-master)
-> Select folder
- Workspace : Choose the workspace for the source code (Default: C:\Employee\Employee Workspace\) -> Fix Automatically -> Genuitech elevation layer : Yes


**************************************************************
*** Option 2 *** <br>
Clone an existing Git repository <br>
- Get full source code at github <br>
https://github.com/thanhcii/EmployeeMonthlyPayslip <br>
- Launch Eclipse IDE -> Clone an existing Git repository <br>
- Repository URL : https://github.com/thanhcii/EmployeeMonthlyPayslip <br>
- Workspace path: Your chosen workspace (Default: C:\Employee\Employee Workspace\) <br>
- Fix Automatically -> Genuitech elevation layer : Yes
- Finish 
- Clone Git Repository(Default Settings) -> Next -> Next -> Finish
- Project explorer -> Import project -> Maven -> Existing maven project
- Root directory : Choose your source code path that you have just unzip to (Default: C:\Employee\EmployeeMonthlyPayslip-main\spring-boot-import-csv-file-app-master) <br>
Make sure to check on /pom.xml
- Add project to working set : spring-boot-import-csv-file-app

**************************************************************
RUN THE SOURCE
- Now Eclipse IDE has run successfully with the source code
-> Project explorer -> spring-boot-import-csv-file-app-master -> Run as -> Spring Boot App -> OK
- Wait until Spring boot finish initialzing server
- Open your Internet Explorer (eg: Google Chrome)
- Go to site -> http://localhost:8080/ <br>
You may config the default port 8080 to other port (eg 8083) by go to 
Project explorer -> spring-boot-import-csv-file-app -> src/main/resources -> application.properties
Type server.port=8083 in editor -> Save -> Re-run the app
Now you can use port 8083 as default tomcat server port -> Go to site -> http://localhost:8083/ 
- Upload the CSV file -> Choose file (.csv) -> Submit

NOTICE: Import file must have Headers columns: Firstname, Lastname, Annual Salary, Superrate, Paymentdate
See the incometax.csv file for examples data

- File Uploaded Successfully. Click to Url for downloading file: http://localhost:8080/api/csv/download/incometax.csv
- Open the IncomeTax.csv file you have just downloaded (Default: C:\User\{your_user_name}\Downloads\IncomeTax.csv) <br>
<br>
DONE!!!!!!!!!

Contact me if you could not run the source at:
Email: thanhciix2@gmail.com





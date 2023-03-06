# ILovePdfWebsite

Simple automation of some functionalities of the ILovePdf's website (https://www.ilovepdf.com) on multiple browsers and platforms.

## Requirements
- Java 11 or above
- Maven

## Setup
1. Build the Maven dependencies in the pom.xml file
2. In the project root folder run `java -jar selenium-server-4.8.1.jar standalone`

## Run tests
In the project root folder run `mvn test -DsuiteXmlFile=testng.xml`

*For mac users, the applescript needs to be updated with the right path : "/Users/**user name**/**path until the project**/ILovePdfWebSite/ILovePdfWebsiteProject/src/com/data/ShoppingListData.xlsx"*
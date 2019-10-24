## README.md

### Contributors
Sanchita Kanade <sanchitamystudies@gmail.com>
   
### Project Description
• Designed a SpreadSheet application using Interpreter pattern, Observer pattern and Memento pattern
• Programmed the spreadsheet with equation view and value view of 9 cells with GUI that allow users to enter either a number or a postfix   expression in the equation view and to get results in the value view
• Used Interpreter pattern to evaluate postfix expressions, Observer pattern to update all dependent cells whenever a user modifies one cell and Memento pattern to add an undo mechanism to the spreadsheet
• Tested application using Junit, in order to make sure that all design patterns are working fine and program accepts only valid input 

### Getting Started
1. Download all files in this project and run the project using IntelliJ IDEA or eclipse 
2. ToggleViewsGUI.java file contains the main method for this project
3. Users can toggle between views using toggleButtonGUI
4. Users can enter either a number or a postfix   expression in the equation view and it is required to press enter key after changing the value or expression in the equation view in order to reflect that change in the value view. If user changes the formula for any cell then dependant cells will be updated automatically after pressing an enter key.

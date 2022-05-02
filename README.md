# SER502-Spring2022-Team36

Members:

Venkata Kanaka Rama Meher Virinchi Gudimetla - 1223592279 - vgudimet

Sai Chandra Kaushik Reddy Parvatala - 1224356627- sparvat6

Nihal Singh - 1223932476 - nnolas27

Prakruthi Ravandur Madesh - 1211219734 - pravandu

Anila Devarashetty - 1222977366 - adevaras


----------------------------------------------------------------------------------------------------
## Programming Language Name: PLan (Programming-Language)


Language Extension: (.plan)

TOOLS AND ENVIRONMENT

Language used - Java 1.8

### ANTLR4 - Another Tool for Language Recognition (Version -4)

    * Installation

        1. Install Java version 17.0.3 or higher 
        2. Download the complete antlr-4.9-complete.jar (or any required version) from https://www.antlr.org/download/, 
           save this in your third party java libraries.
        3. set the classpath for the jar file SET (CLASSPATH=.;C:\Javalib\antlr-4.9-complete.jar;%CLASSPATH%)


### Eclipse - IDE 

    * Installation
        
        1. Open your browser and type https://www.eclipse.org/
        2. Click on download and select the 64 bit version
        3. Open the downloaded file and click on “eclipse-inst-win64.exe” file to install the IDE

### Grammar and Syntax

    * In the repository PLan.g4.html under PLan Syntax and grammar/ folder gives static web page with clear flow of grammar.
      Click on rules on the left hand side of the web page followed by click on non-terminal commands to get the visual and text notion of grammar and syntax.
    

### Running our project

    1. clone the repository into your local machine 
    2. After cloning the repository, run the below commands in terminal to generate
       intermediate code by compiler.jar and use the .planint file to get 
       the output of the sample file using runtime .jar
        
            java -jar compiler.jar modelPRograms/fibonacci.plan
            java -jar runtime.jar modelPRograms/fibonacci.planint

### Future Works
    
    1. Enable string operations and data manipulation with string.
    2. Support for data structures like array, stack and queue.
    3. Support of external libraries.

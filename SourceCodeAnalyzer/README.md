# SourceCodeAnalyzer

## Contents
---
1. [Purpose of the project](#purpose-of-the-project)
2. [Requirements](#requirements)
3. [How to build and run the project](#how-to-build-and-run-the-project)
4. [Process of performing the exercise](#process-of-performing-the-exercise)
	- 4.1 [Intoduction](#introduction)
	- 4.2 [UML Diagram](#uml-diagram)
	- 4.3 [Covered Requirements](#covered-requirements)
	- 4.4 [Design Patterns](#design-patterns)
		- 4.4.1 [Strategy](#strategy)
		- 4.4.2 [Factory](#factory)
		- 4.4.3 [Null Object](#null-object)
		- 4.4.4 [Facade](#facade)


## Purpose of the project:
---
In this module we practice the implementation of design patterns.

In this project it is given a Java source code file that is stored locally or on the web, it calculates the Lines of Code (LOC), Number of Classes (NOC) and Number of Methods (NOM) metrics, and in the end exports these metrics in a file.

The purpose of the assignment is to modify the code and implement some design patterns, in order to improve the design quality of the system.

## Requirements
---
- maven
- java

## How to build and run the project
---
1. In order to build the project press:

	```bash
	$ mvn package jacoco:report
	```

2. Run the program by executing
   
   ```bash
	$ java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
	```
	
	were args are the following: 	

	- arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
	- arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
	- arg2 = “SourceCodeLocationType” [local|web]
	- arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
	- arg4 = “OutputFileType” [csv|json]
  
	Example: 

	```bash
	$ java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java strcomp web metrics_results csv
	```


## Process of performing the exercise
---
### Introduction
The following class diagram visualizes the refactored source code analyzer.

In this UML diagram there are 3 packages:
- exporter
- analyzer
- reader

For instance, I will describe one package. Inside the package `exporter` there is the interface `MetricsExporter`, which contains only the method `writeFile(...)`. There are also 3 classes, `CsvExporter`, `JsonExporter` and `NullExporter` that implement the interface `MetricsExtractor` and finally there is the class `MetricsExporterManager`, that it is responsible for creating the interface.


### UML Diagram
![](https://github.com/NikosKakonas/Software_Engineering_Assignments/blob/development/SourceCodeAnalyzer/src/main/resources/UML.png)



### Covered Requirements
All design decisions that led to the current design were taken to satisfy the following requirements:
1. The system should be __extendable__ in the three dimensions (SourceAnalyzers, MetricsExporters and ContentReaders).
2. When extending (or changing) one of the three dimensions, keep other dimensions in mind.
3. Within the classes, reduce complexity and code duplication
4. Make the system reusable for a variety of clients (minimize coupling with Client)


## Design Patterns
---
### Strategy

For each dimension (SourceAnalyzers, MetricsExporters, ContentReaders) a Strategy pattern was applied. In each case we introduced an interface that describes the functionalities that the concrete classes should implement. The application of this pattern has the following advantages(+) and disadvantages(-) to our system:

#### Advantages (+):
- Each dimension can be increased independently of the others without influencing the rest of the system
- We get rid of the many if statments inside the classes, and as a result we reduces the complexity of the program and code duplication
- Concrete objects, such as, ```CVSExporter``` and ```JSONExporter``` are now interchangeable

#### Disadvantages (-):
- A lot of new classes were added in the project, which may make the code a little difficult to understand
- Concrete objects are limited to the functionality that their interfaces offer.


### Factory

Every package has its own Factory pattern. For instance, the package `exporter` has as a Factory the class `MetricsExporterManager`, the package `analyzer` has as a Factory the class `SourceCodeAnalyzerManager` and lastly the package `reader` has as a Factory the class `SourceFileReaderManager`. Those classes are now responsible for creating and instantiating the concrete objects of each dimension. With this pattern added, the system has the following advantages(+) and disadvantages(-):

#### Advantages (+):

- We limit the coupling of other classes to each dimension by hiding the creation details of concrete objects (module).
- Apart from their respective Factory class, each dimension can be increased without affecting other modules.

#### Disadvantages (-):

- Because a middle-man class is usually called when generating an object, we added some communication cost to the system.


### Null Object

In each Strategy pattern we introduced a Null Object, that manages the cases that a not implemented or specified class is requested to perform a functionality. The messages, that the Null Object prints, are not illegible and the user can correct easily something that went wrong. With this pattern added, the system has the following advantages(+) and disadvantages(-):


#### Advantages (+):

- We limit the coupling of other classes to each dimension by hiding the creation details of concrete objects
- A specific error message that is a true indicator of the error that happened can be received by the user.

#### Disadvantages (-):

- If not managed properly, it has the potential to obscure the underlying source of a caused error, causing more harm than benefit.


### Facade

As a Facade of our source code analyzer system, the `DivideActivities` entity was introduced in the design. All object instantiations and calls have been transferred from the `Client` to the `DivideActivities`. The application of this pattern has the following advantages(+) and disadvantages(-) to our system:

#### Advantages (+):

- All ties between the system and the client were severed (apart from the Facade). The system can now change with the least amount of impact on the client
- Different methods (or even varied Facades) can be added to the system to offer the Client with different functions

#### Disadvantages (-):
- We didn't lower the system's overall complexity; rather, we outsourced it from the Client to the Facade. Furthermore, we contributed additional code to the system (a new class) that must be maintained
Due to various (non-injectable) dependencies, Facade is - difficult to test using standard unit tests

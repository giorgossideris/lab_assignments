# sourcecodeanalyzer

## Purpose
This module serves as a hands-on practice on Design Principles and Patterns. More about the Design Patterns can be found in section [Design Patterns Used](#design-patterns)

## Tools
The tools used in this repository and necessary to build it are:
* Java *(12 or up will work for sure)*
* Maven *(3.6.3 or up will work for sure)*

## How to build and run
1. **Clone the project:** Execute the command `git clone https://github.com/giorgossideris/lab_assignments.git`
2. **Move into this module:** Execute the command `cd lab_assignments/sourcecodeanalyzer`
3. **Build the module:** Execute the command `mvn package jacoco:report`
4. **Run the jar:** Execute the command `java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4` were args translate to: 	
    * arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
    * arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
    * arg2 = “SourceCodeLocationType” [local|web]
    * arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
    * arg4 = “OutputFileType” [csv|json]  
   example: `java -jar target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv`


## Class diagram
The class diagram that represent the system of this module can be found at [ase_4th_assignment_uml Class diagram.png](https://github.com/giorgossideris/lab_assignments/blob/development/sourcecodeanalyzer/ase_4th_assignment_uml%20Class%20diagram.png) (it may be necessary to open it to new tab, to be shown correctly).

## <a name="design-patterns"></a>Design Patterns Used
In this section the Design Patterns used will be presented.

### <a name="strategy"></a>Strategy
  - Classes that participate
    1. SourceFileReader, LocalFileReader, WebFileReader
    2. ReaderContentFormer, ListReaderContentFormer, StringReaderContentFormer
    3. MetricCalculator, MetricCalculatorFromString, MetricCalculatorFromList, RegexMetricCalculator, StrcompMetricCalculator
    4. MetricsExporter, CsvExporter, JsonExporter
  - General Benefits
    1. Lower complexity.
    2. Higher cohesion.
  - General Disadvantages
    1. Children are not interchangeable.
    2. Extending a functionality requires a change in the factory, when one is used.
  - Why it is used
    Strategy allows the usage of different algorithms for the same general purpose. Specifically, following the numbering of classes:
    1. File reading from different sources.
    2. Turning the content of the files into different forms.
    3. Calculating metrics with different methods.
    4. Exporting into different types of files.

### Factory
  - Classes that participate
    1. SourceFileReaderFactory
    2. MetricCalculatorFactory
    3. MetricsExporterFactory
  - General Benefits
    1. Separation of concerns, as factories are responsible for initializing.
    2. Flexibility, as a change in hierarchy, that the factory handles, can be managed within the factory.
  - General Disadvantages
    1. Code a bit more difficult to understand (especially in bigger systems), as logic is hidden behind abstraction.
  - Why it is used
    Factory handles the logic of initialization of objects, complementing nicely the [Strategy](#strategy) pattern. Specifically, following the numbering of classes:
    1. Initialization of sourceFileReaders based on the source type.
    2. Initialization of metricCalculators based on the analyzer type.
    3. Initialization of metricsExporters based on the type of output file.

### Facade
  - Classes that participate
    1. AnalyzeManagement
    2. InformationGenerator
  - General Benefits
    1. Portability and and independence of the subsystem.
    2. Customer does't need to call a large number of classes, but only the facade.
    3. Layering the subsystem.
  - General Disadvantages
    *No disadvantages found.*
  - Why it is used
    Facade allows the subsystem to be used as an independent library, as facade classes work as a simple interface to the complex system. 
    Specifically, following the numbering of classes:
    1. AnalyzeManagement works as a general interface, handling the reading of the source code, the calculations of the metrics and their exporting.
    2. InformatinGenerator works as an interface that handles the reading of the source code and the calculations of the metrics (is called by the AnalyzeManagement).

### Bridge
  - Classes that participate
    1. MetricCalculator and ReaderContentFormer
  - General Benefits
    1. Separation of concerns.
    2. Extensibility.
  - General Disadvantages
    1. Increased complexity.
  - Why it is used
    Bridge allows both the interaction and easy extensibility of MetricCalculator and ReaderContentFormer. More about the particular implementation [here](#metriccalculator-inheritance).

###  Null Object
  - Classes that participate
    1. NullFileReader
    2. NullMetricCalculator
    3. NullExporter
  - General Benefits
    1. Simplification of the code as Null Objects handle the null (unexpected, invalid) cases.
  - General Disadvantages
    1. Hiding of mistakes and errors.
  - Why it is used
    Null Objects are very helpful in the particular system, as they handle invalid inputs, so that they don't need to be handled in other parts of the code.
    Specifically, following the numbering of classes:
    1. NullFileReader handles invalid file sources.
    2. NullMetricCalculator handles invalid analyzer types.
    3. NullExporter handles invalid types of output file.

## Additional Design Decisions
  * <a name="metriccalculator-inheritance"></a>**MetricCalculator inheritance within inheritance**    
    A controversial design decision is the one about the creation of abstract subclasses of the MetricCalculator, that in reality just define
    the ReaderContentFormer for the MetricCalculator. This design has both advantages and disadvantages. On the one hand the complexity is lower,
    the initialization of the MetricCalculator is independent of its ReaderContentFormer and it is safer, as the correct ReaderContentFormer will be 
    assigned to the MetricCalculator. On the other hand, MetricCalculator and ReaderContentFormer are highly coupled. I concluded that it is a worthy trade-off.
  * **Metric class and MetricLoader**
    In order to avoid the repetition of code, the Metric class was created, in which are defined the only fields and methods that are necessary to be known to calculate 
    the metric by a general calculateMetric method. MetricLoader is necessary for the initialization of the metrics, but also gives the ability to calculate only certain
    metrics and not all of them.
    
## General Observations
  The whole refactoring of the code was based on the SOLID design principles and trying to avoid the 7 software design sins (as presented in the labs).
  In order to do that abstractions, interfaces, design patterns and packaging of classes were used.



*Note: Benefits and Disadvantages of the Design Patterns are largely based on the labs' slides.*
    

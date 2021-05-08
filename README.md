[![Build Status](https://travis-ci.com/giorgossideris/lab_assignments.svg?token=MMr6Hepy3ETDrm4TaxdD&branch=development)](https://travis-ci.com/giorgossideris/lab_assignments)
# lab_assignments

## Purpose
This repository contains the lab assignments of the subject "Applied Software Engineering".

## Tools
The tools used in this repository and necessary to build it are:
* Java *(12 or up will work for sure)*
* Maven *(3.6.3 or up will work for sure)*

## How to build and run
1. **Clone the project:** Execute the command `git clone https://github.com/giorgossideris/lab_assignments.git`
2. **Move into the project:** Execute the command `cd lab_assignments`
3. **Build the modules:** Execute the command `mvn package`
4. **Run the jars:**
   1. In order to run the jar for HistogramGenerator execute the command 
  `java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar gradeshistogram/src/main/resources/grades.txt`
  
## Notes
1. unittesting module refers to practice on Unit Testing and you can read more about it [here](https://github.com/giorgossideris/lab_assignments/blob/development/unittesting/README.md)
2. In case you want to get a report for the test covery of each module execute the command `mvn package jacoco:report` (from the parent folder). The results can be found in the path: **target/site/jacoco/index.html** of each module (*Caution:* the report will be produced only if tests are run in the particular module).

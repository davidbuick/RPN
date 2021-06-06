A tool to compute reverse polish notation. It supports
1) basic operations + - * / sqrt
2) functionality clear and undo 

Example 1:
5 2
stack: 5 2

Example 2:
2 sqrt
stack: 1.4142135623
clear 9 sqrt
stack: 3

See RpnMainTest for more example usages.

Commandline to run:
- mvn clean assembly:assembly
- java -jar RPN-1.0-SNAPSHOT-jar-with-dependencies.jar

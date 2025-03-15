
[https://canvas.seattlecolleges.edu/courses/30144/assignments/535451]
Graph Project (Optional)

Purpose: To practice and demonstrate proficiency in using graph algorithms in implementation.

Skills Used: Java programming

Knowledge Goals: Floyd-Warshall Algorithm, Dijkstra's Algorithm, Bellman-Ford Algorithm, DAG-based Shortest Path Algorithm, Prim-Jarnik's Algorithm, Ford-Fulkerson Algorithm


Summary

In this project, you will work independently to implement several graph algorithms that we went over in class. You will you your own Github Repo for this and submit a link to it as submission. This assignment will be more general in its instructions than we are used to as it is optional. Please see under Assessment for what it will be worth.

You must create a graph of a minimum of 6 nodes and minimum of 7 edges.

Please complete between 1-3 algorithms (see Assessment below for value of doing 1-3). Restrictions on implementation are below each one.

    Floyd-Warshall Algorithm for Transitive Closure
        Must use a directed graph (digraph).
    Djikstra's Algorithm
        Must use an undirected graph and show which edges become relaxed as well as the shortest path.
    Bellman-Ford Algorithm
        Must use a directed graph (digraph) and result showing the shortest distances from the source to each vertex.
    DAG-based Shortest Path Algorithm
        Must use a directed acyclic graph (DAG) and result showing the shortest distances from the source to each vertex.
    Prim-Jarnik's Algorithm
        Must use an undirected graph and result showing the minimum spanning tree, as well as what edges are relaxed.
    Ford-Fulkerson Algorithm
        Must use directed graph (digraph) and show the flow weights before and after all iterations of the FF algorithm. Must also indicate what the maximum flow would be and which edges the min cut would cover.


Part 1: Designing the Program

Things to consider when designing your program:

    You do not need to create UML diagrams for this project.
    Where will you get your graph data structure code? Will you create it yourself? Will you use the code from AD 325 last quarter? That choice is yours.
    Which algorithms will you implement for this project?


Part 2: Java Implementation

The implementation of this is largely up to you. Here are a few things I look for in well-designed implementations:

    Follows principles of OOP: Inheritance, Polymorphism, Abstraction, Encapsulation
        I'm not checking for each one of these. Obviously, there are situations where none or very few will be used and there are situations where all may be used. Use your discretion.
    Well-organized project structure.
        This could include multiple packages or possibly not. 
    Use of Interfaces.
        For any classes where it will be relevant, use of interfaces is a great idea. Not required for this project, but optional.


Part 3: Unit Testing

As before, provide unit tests. Strive for at least 70% method code coverage.


Part 4: Illustrating and Analyzing Results

    Be sure that the grader can see results that SHOW you algorithms are working.
    I am not going to hand-hold how you do this but if I cannot tell the algorithms are working, you will not get credit.
    The best way I would say to do this is show the state of the graph before the algorithm is executed and then show the state of the graph after it is executed. Explain in your output from your program how the graph has changed and why it changed. If I can see that, you will get full credit.
    Junit tests are amazing and I encourage them but I really need to see textual output showing the states of the graphs before and after the algorithm.  
        I will make one provision in this regard. If you can provide me ample comments in your program about how each Junit test proves your algorithms work, I will consider that as acceptable. Documentation is absolutely key in this regard if you choose to go with a junit-test only output.


Some other items of importance

    Use javadoc comments on your functions to explain what they do. You do not have to do this in the class implementations where there is an interface, you can use @inheritDoc.
    Be sure your code is clean, legible and easy to read.
    Feel free to go above and beyond!  Add new methods and functionality, test in different ways in addition to what you are required to do, be creative! The top grades go to those who go above and beyond. Strive for excellence.
    You are not required to create unit tests but are welcome to do so if you wish.
    Including the runtime as a comment on algorithms with loops in them will be seen as going above and beyond as well.


Format Requirements

    Please ensure you follow the structure as listed above. Use IntelliJ to do your work. Use javadoc comments where appropriate.
    Please use your own repo for this assignment.


Assessment

This will be assessed in the following way:

If you implement 1 graph algorithm and show it works, you will get +25 points on one of the Analysis of Algorithms written assignments.

If you implement 2 graph algorithms and show it works, you will get +50 points on one of the Analysis of Algorithms written assignments.

If you implement 3 graph algorithms and show it works, you will get +100 points on one of the Analysis of Algorithms written assignments.

You can only get a maximum of 120 points on any assignment. Let says you have assignment grades of 86, 100, and 94 so far. If you implement 2 algorithms you get 50 points, you will change your first grade to 120 (120-86 = 34) and your third grade to 110 (110-94 = 16) for a total of 50 points given points. Anything thats left over is lost.


Deliverables

    Github repo link.

Rubric
FSM Project
FSM Project
Criteria 	Ratings 	Pts
This criterion is linked to a Learning Outcome Implementation, Output & Testing
This evaluates the implementation, output for your project, including console output and charts created.

25 to >20.0 pts
Above and Beyond
Implementation is solid and goes above and beyond. Output exceeds expectations in interesting ways. Charts will be professional and well-polished with possibly additional content. Additional, robust testing is included with possible innovative ways to ensure intended output of the project is maintained. Output is professional and well-spaced, easy to read. Unit tests may be used but not necessary.

20 to >10.0 pts
As Expected
Implementation is solid. Output is as expected from project instructions. Charts are readable and well-designed. They also make sense. Testing done reflects intention of ensuring methods being used work accurately. Output is readable and clear.

10 to >0.0 pts
Under Expectations
Implementation has bugs or is designed very poorly. Output does not meet expectations. Charts are not professional or are difficult to decipher. Either the output results are not accurate or the testing is done improperly. Output results may be hard to read and unprofessional.

0 pts
Output/Testing Missing
Testing through an output is missing. Code possibly does not run.

25 pts
This criterion is linked to a Learning Outcome Class Structure and OOP
This evaluates the use of Object-oriented principles as well as the accurate creation of expected classes and methods.

25 to >20.0 pts
Above and Beyond
All classes and methods exists as expected. • Additional methods exist to test new functionality not required by the project. • OOP principles are used including encapsulation, inheritance and polymorphism (if it makes sense to do so). • ADT data structures could be reused for alternative class implementations without a problem. • Innovative methods of execution are implemented including but not limited to using Iterators instead of using standard loops. • Interfaces are used properly and may include additional functionality such as constants and/or default methods. • Exceptions are implemented correctly and may include additional exceptions.

20 to >11.0 pts
As Expected
All classes and methods exists as expected. • OOP principles are used including encapsulation, inheritance and polymorphism (if it makes sense to do so). • ADT data structures could be reused for alternative class implementations without a problem. • Interfaces are used properly • Exceptions are implemented correctly

11 to >0.0 pts
Under Expectations
Not all classes and methods exists as expected. Some may be missing or implemented incorrectly so their functionality does not work. • OOP principles may not be maintained. • ADT data structures could not be reused for alternative class implementations without a problem because implementation specific elements exist in the ADT (such as accessing variables in another class specific to the project rather than keeping it general for the ADT). • Interfaces may not be used properly or missing. • Exceptions are not implemented correctly or may be missing.

0 pts
Code Does Not Run
Code does not run without error.

25 pts
This criterion is linked to a Learning Outcome Java Formatting and Structure
This category is intended to evaluate the usage of the structure of the project (packages, etc.), the Javadoc comments included, standard comments and readability of the code.

20 to >16.0 pts
Above and Beyond
• Structure of Java project well-defined with usage of packages if it makes sense, meaningful names of files and good organization. • Proper use of naming conventions for Java (Camelcase) • Usage of Javadoc comments on each method (inheriting from Interfaces is acceptable) • Comments on complex code included and robust. • Code is very readable and easy to understand.

16 to >12.0 pts
Good (Javadocs Missing)
Same as Above and Beyond except Javadoc comments are missing.

12 to >8.0 pts
As Expected (Except Javadoc comments)
• Structure of Java project well-defined with usage of packages if it makes sense. • Comments on complex code included. • Code is very readable .

8 to >0.0 pts
Under Expectations
• Structure of Java project not well-defined, possibly missing use of packages. • Usage of Javadoc comments missing, sparse or incorrect. • Comments on runtime on all algorithms either sparse or missing. • Code may be difficult to read.

0 pts
Code Does Not Run
Code does not run without returning an error.

20 pts
This criterion is linked to a Learning Outcome Version Control Usage
This category is intended to evaluate the group's usage of version control through Git and Github

10 to >8.0 pts
Professional
Use of Git and Github is professional. Pull requests are used frequently with robust comments and feedback, commits are commented on with relevant information and merge conflicts are handled appropriately.

8 to >6.0 pts
Student
Use of Git and Github is at a student level. Pull requests are used sometimes with few comments, commits are commented on sometimes and merge conflicts are handled.

6 to >0.0 pts
Novice
Use of Git and Github is at novice level. Pull requests are used infrequently, commits are not commented on or are very infrequent and merge conflicts may or may not be handled appropriately.

0 pts
Version Control Not Used
No Evidence of appropriate version control usage. No pull requests, pushing right to main branch.

10 pts
This criterion is linked to a Learning Outcome Report
This category is meant to cover how well the report is completed. It evaluates if all questions are answered in an effective way as well as if professionalism is used.

20 to >17.0 pts
Above and Beyond
All report questions are answered with analytical answers. Equations are provided where useful. Report is organized and well written with little spelling or grammar errors. References may be included as well things like title page and table of contents.

17 to >12.0 pts
Good
All report questions are answered with analytical answers. Report is organized and well written with little spelling or grammar errors. Professionalism is apparent.

12 to >8.0 pts
Adequate
All report questions are answered. Report is somewhat organized and written with some spelling or grammar errors. No extra effort for professionalism.

8 to >5.0 pts
Poor
Some report questions are answered. Report is not organized and written with spelling or grammar errors. No extra effort for professionalism.

5 to >0 pts
Very Poor
Very few report questions are answered. Report is not organized and written with many spelling or grammar errors. No professionalism.

20 pts
This criterion is linked to a Learning Outcome Graph Theory
threshold: 3.0 pts

4 pts
Exceeds Mastery

3 pts
Mastery

2 pts
Near Mastery

1 pts
Below Mastery

0 pts
No Evidence
	
-- 
Total Points:
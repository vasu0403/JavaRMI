# Distributed Systems Assignment 3
---
## JAVA RMI
### Instructions
Programming language used: Java
To run the code:
```
javac *.java
java Server <port_number>
java Client 127.0.0.1 <port_number>
```
### Architecture
-   For this assignments, java RMI(Remote Method Invocation) has been used.
-   Java RMI is a mechanism that allows an object residing in one system (JVM) to access/invoke an object running on another JVM.
-   The server provides an interface, using the functions of which the client can tell the server to either add a new graph or to add a new edge in an existing graph or ask for the MST of an existing graph.
### Algorithm Implementation
-   For finding the MST I have used kruskal's algorithm, which maintains the information about disjoint sets present in the graph. (Time complexity of kruskals is O(M log M) where M is the number of edges).
-   If there is only one disjoint set, that means the graph is connected and the MST of the graph is returned. If there are more than one disjoint sets in the graph (every vertex does not have the same parent vertex), than the graph is disconnected and MST does not exist and -1 is returned.
-   For storing different graphs, I have used a hash map, which maintains edges present in the graph for each graph identifier.

### Results and Observations
On a graph with 10^4 nodes and 10^4 edges, the server takes around 0.93 seconds to process all the requests (which includes requests to make the entire graph, and 10 requests for MST). 

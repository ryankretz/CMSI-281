Ryan Kretz
CMSI-281
Homework 6
========

insert: In order to implement the insert functionality, I wrote a private insert method that uses recursion to insert the value to the binary tree. In the private method, I check to see if the root is null (base case) in which case I create a new node with the desired value. Otherwise I check to see if the desired value is less than or greater than the current node in which I traverse to the left or the right, respectively. Once I reach the end, the base case gets called and a new node gets created. The created node is returned in the private method. 

findSmallestValue: In order to implement the findSmallestValue functionality, I check to see if the root is null in which I throw an ItemNotFoundExceptoin and use a private method that uses recursion to find the smallest value in the binary tree. In the private method, I check to see if the node to the left is null (base case), which signifies there is nothing there so the current node is the smallest. Otherwise, I traverse left until the current node is null and the base case gets called. The value of the node that is furthest to the left is returned.

findLargestValue: The functionality of findLargestValue is identical to the functionality of findSmallestValue, however, I traverse right instead of left as the node furthest to the right has the greatest value. 

contains: In order to implement the contains functionality, I wrote a private method that uses recursion to find if the value is in the binary tree. In the private method, I check to see if the current node is null in which I return false as there is no root. Otherwise, I check to see if the desired value is less than or greater than the current node in which I traverse left or right, respectively. If the value is not less than or greater than the current node, it must be equal, so true is returned. 

toPreOrder: In order to produce a preOrdered integer array, I use a private method that uses recursion to add the values of the binary tree. In the private method, I check to see if the node is not null in which I add nodes to an arraylist in order of root, left, and then right.

In the main method, I check to see if the root is null in which I create an empty array and return the empty array. Otherwise, I create an array with the size of the arraylist and add the values from the arraylist to the array. 

toInOrder: The functionality of toInOrder is identical to the functionality of toPreOrder, however, I add the nodes in the order of left, root, and then right. 

toPostOrder: The functionality of toPostOrder is identical to the functionality of toPreOrder, however, I add the nodes in the order of right, root, and then left.

toBreadthFirstOrder: In order to produce a breadthFirstOrdered integer array, I used a private method that adds the values of the binary tree. In the private method, I create a queue with the head as the root. While the queue is not empty, I add the head to the arraylist and then check to see if it has a left or right child. If so, I add the children in the order of left to right to the arraylist. 

In the main method, I check to see if the root is null in which I create an empty array and return the empty array. Otherwise, I create an array with the size of the arraylist and add the values from the arraylist to the array.

========

All of the pre-written tests past as expected. 






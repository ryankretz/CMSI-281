Ryan Kretz
CMSI-281
Homework 4
========

For this assignment, I used a an abstract base class TheCollection which contains size and recent variables to keep track of the amount of objects added to the collection and how many are wanted to be saved, respectively. I chose to use an abstract base class as all of the collections need to have the same functionality, so the abstract base class contains the abstract methods that should be overridden depending on how the collection works. In other words, to the outside world, the collections all behave the same as one can call methods in the same manner, but in reality, each collection's inner workings are quite different.

I decided to use Java's LinkedList as my third implementation because I felt that it contianed more built in functionality that allowed me to perform certain operations more easily. For instance, LinkedList makes it easier to simply add an object to the end of the list and then remove the first object from the list. If an ArrayList was used, behind the scenes, it would create a new array each time, which would take up more memory and have a greater execution time. 

==================

As I addressed earlier, since all of the collections are able to be called in the same manner, I was able to use virtually identical tests for all of the required 8 tests. In each case, I created the certain type of collection, added some objects, and then checked to see if the functionality of the collection was correct. The only discrepency I found was that when using Java's LinkedList's built in iterator method, the next() method started from 0 rather than 1. In my other collections, the next() method returns the object after the current object, so if it started at 0, it should return 1. However, the built in functionality of the LinkedList's iterator must be different than mine, so in my iteration test, I accounted for this by starting the predicted value at 0 rather than 1. 





Ryan Kretz
CMSI-281
Homework 3
========

My SuperSweetGame utilizes a character heiarchy that distinguishes the different types of characters. The main game object class is abstract as it serves to establish the basic functionality needed for each object (just some getters that permit functionality below). The game object implements a render interface as all objects created will need to have a "getRenderedCharacter()" method in order to display what they are. Extending from the game object class are two other abstract classes: moveable and stationary. These classes serve to distinguish between objects that can move in the game and those that cannot. Objects that move in the game must have other fields, such as displacement and hp, therefore, they are different than the stationary objects. 

The player, each type of monster, and each type of boss all extend from the moveable class. The player class has a super construct, get rendered character, and check collision. The check collision method checks if the player is colliding with a stationary object (in which it distinguishes a wall versus a tree or rock and adds hp accordingly) or moveable. If it is a moveable, then it finds out which one it is and performs the calculation to find if it gets hit or hits the other object. 

I also have abstract classes that define the functionality of each type of monster or boss. These classes contain the super constructor and the check collision method. The check collision method is similar to the player's check collision, however, it does not check if it collides with other monsters as that was not specified in the assignment. Along with this, each specific monster has a "getRenderedCharacter()" that returns its respective character. 

Extending from the abstract stationary class, there are rock, tree, and wall. These classes contain their respective constructor and "getRenderedCharacter()" methods. 

I chose to structure my game in this manner because I felt that it appropriately defines the type of each object and how it is related to the other objects. This allowed me to minimize the code in the specific object classes as most of the basic code was inherited from the super classes. Also, I chose to use render as an interface because I felt that it was an action that is common among all objects and did not contain any variation in its usage. Therefore, it could be easily implemented as an interface for all the game objects. 

==================

For my Junit testing, I attempted to test as much of the functionality as I deemed fitting. I did not feel that it was necessary to check how each specific object interacted with another specific object because many of the classes extend the same super class. So, if one of them works properly, then the other should as well. 

I did not test whether or not a player collides with a monster because the hp generation is a percent range. So, even if I know where the two will collide, I cannot determine which will hit which. I thought by creating a large loop that tested the collision many times and then determine if which object hit which, I could "predict" the hp outcomes. However, during the process of writing this, I ran into many errors that didn't allow me to correctly predict the outcome every time. 

I know that there are ways that I could have simplified the code more, but I feel that my code is adequate for the purpose of the game as I utilized class heiarchy, abstract classes, and implemented an  inferface. 





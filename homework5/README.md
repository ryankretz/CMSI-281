Ryan Kretz
CMSI-281
Homework 5
========

For each of the recursive problems, I broke the problem into pieces in order to see how I could write the different methods to call themselves. For the Fibonacci sequence, I check the initial conditions (the first three fibonacci numbers) and then have the basic formula for calculting a Fibonacci number. For the recursive multiplication, I check to see if one the input numbers is equal to zero as this would immediately result in 0. If the input numbers are not zero, I used a formula that recursively adds the first number to the second number minus one. For the recursive string to integer conversion, I check to see if the string is empty or is a single number, which return 0 and the converted number, respectively. Otherwise, the length of the string is used to add the last character to the other characters multiplied by ten. Finally, for the balanced parenthesis problem, I used a loop to push the opening paranthesis or bracket to the stack. I also checked to see if the current character was a closing paranthesis or bracket. From this, I could determine if the current paranthesis or bracket was in the correct placement if the stack was empty or if it did not have a corresponding paranthesis or bracket.   

========

I tested each method twice, tyring to seperate different cases that would display the functionality of the each method. For the Fibonacci method, I tested the method two "small" numbers and two "big" numbers. For the recursive multiplaction, I tested the method with different cases of the inputs being 0 and with various integer values. For the recursive string to integer, I tested the method with a "big" value, with a "small" value, and with an empty string (the small value and empty string tests were grouped together). Finally for the balanced paranthesis, I tested the method with two sets of balanced paranthesis and two sets of unbalanced paranthesis.






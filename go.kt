Frank Chen
APCS2 pd2
HW12 -- __+3R|\/|1|\|4|_  1|_|_|\|3$$__
2018-03-01

Q0: What do you make of the multiple class definitions in a single .java file?
	It seems really convenient as the user can work on multiple classes in the same file. 


Q1: How are the command line arguments processed?
	The “go” method within class Boardasaurus takes in two parameters: “int moves” and “int t”. 
	Moves would determine the size of the n*n board, while t determines the time delay in 
	milliseconds between each move.


Q2: What happens if no command line arguments are given?
	In the main method, “moves” and “t” have a default value of 8 and 500. Simply running java 
	Demo would run the animation on an 8x8 board with moves every half a second.


Q3: What is the nature/purpose of the recursion? Is it necessary for the animation?
	The recursion increases the move count each time a value on the n*n board is changed. I don’t 
	think it’s necessary as iteration should be able to do the same, but recursion is the simpler 
	method to do so.


Q4: What do you expect to see when you run it?
	I’d expect do see random numbers on the board change into the value of moves, with moves increasing 
	by 1 every time.


Q5: How long do you expect it to run?
	It should run until the move count surpasses the size of board. That being said, I’m unsure 
	if the delay method plays a role in this.

Q6: What does ANSI stand for? (You are permitted some intertubes searching here…). What is it good for?
	ANSI stands for “American National Standards Institute”. It’s good for coding in a specific type of 
	format that everyone should be able to read, as that’s the standard format decided by ANSI.


Q7: How did your expectations compare to your observations?
	At first glance, I expected this to be coding for a Knight’s Tour. On deeper inspection, I realize 
	this is simply a demo on animating in the terminal. Nevertheless, it gave me a good glimpse of how 
	animation works and will guide me in making one.


Q8: How might you adapt this framework to animate a probing for a Knight’s Tour?
	I would consider looking in depth into the “go” and “main” method. They seem to contain the basics of animating in a terminal. Furthermore the Thread.sleep inside the delay method was also quite confusing. I would test my animation with/without that method to see if there’s any difference.

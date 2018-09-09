=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: _______
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

- List the four core concepts, the features they implement, and why each feature
  is an approprate use of the concept. You may copy and paste from your proposal
  document if you did not change the features you are implementing.

Concept 1: ___("Appropriately modeling state using 2-D arrays or collections")____

- What specific feature of your game will be implemented using this concept?
Both the board state and the pieces will be represented by 2-D arrays.

- Why does it make sense to implement this feature with this concept? Justify
  why this is a non-trivial application of the concept in question.

As at it's heart Tetris is a grid that either has pieces present or not an array makes the most sense.


Concept 2: ___(Object-oriented design using inheritance and subtyping)____

- What specific feature of your game will be implemented using this concept?
Each individual piece will be it's own object.

- Why does it make sense to implement this feature with this concept? Justify
  why this is a non-trivial application of the concept in question.
Some things will be the same across all pieces, such as falling speed, but other things such as color will be different
so it makes sense to have each piece object to be a subtype of a larger piece class.

Concept 3: ___(JUnit testing)____

- What specific feature of your game will be implemented using this concept?
Collision detection will be tricky, so I'd like to do testing on it.

- Why does it make sense to implement this feature with this concept? Justify
  why this is a non-trivial application of the concept in question.
Since the pieces are being generated randomly it could be time consuming to do testing in game.  I'd need to
play long enough to get the percise combination of blocks and board state to test my edge cases, and I'd
prefer not to have to do that each time I want to make a change.

Concept 4: ___(Collision detection)____

- What specific feature of your game will be implemented using this concept?
To see if falling blocks will stop or to see if a move would be valid

- Why does it make sense to implement this feature with this concept? Justify
  why this is a non-trivial application of the concept in question.
Absolutly essential for the game.  While the framework includes basic col detection, that will not work for Tetris's
more complicated shapes.


=========================
=: Your Implementation :=
=========================

- Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
Game - The SWING GUI for the game. Creates the various windows that show Score, instructions and play area.
 I kept the largely the same as the framework, adding the stuff I needed.
 
 Game Court - Creates and maintains the board for the game.  Does things like keeping track of where fallen blocks are
 col detection, checking for and clearly completed lines, checking loss state and drawing everything.  It also creates
 each new shape class as it is introduced
 
The following are simple classes for keeping track of various private states
Level - every 10 lines completed that game will speed up
Pic - Reads Vladimir for display
Score - keeps track of score

Tetromino - The superclass for the various blocks.  Contains things such as 
- Revisit your proposal document. What components of your plan did you end up
  keeping? What did you have to change? Why?
  
  I ended up keeping most of the basics of the game.  I had to ditch I/O as it proved to be way more complicated than
  I had time to implement.  In the end I realized I had created a non-trivial collision detection system, so I went
  with that.


- Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
I/O was tricky.  I had orginally planned on implementing different classes for each block's rotation but I felt it was
simpler to make a 3D array with the various rotation states.  Keeping the various Ds in mind was tricky, it took a
while before I realized that x and y were different than I had thought.  As expected collision detection was a nightmare

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
Overall I'm happy.  I ended up making numerical values that I knew I'd have to use everywhere private states as that
was easier than constantly passing them around.  Orginally collision detection was private as well but I changed that
in order to make testing easier, I would change it back if this game was for "release."


========================
=: External Resources :=
========================

- Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
  
  I used Tetris wikia's Tetris Guidelines for a sense of what the standard conventions of Tetris are (what exact shapes
  size of the board, etc).  It also gave me ideas for what features I wanted to implement.
  http://tetris.wikia.com/wiki/Tetris_Guideline
  I had planned to explore the Russian themes better, a version I recall from my childhood had pictures glorifying
  the former USSR.  I thought it would be funny to include a series of amusing pictures of Vladimir Putin, which I
  found here.
  http://theawesomedaily.com/42-pictures-that-prove-just-how-much-badass-vladimir-putin-really-is/  



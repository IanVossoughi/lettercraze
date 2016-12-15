# lettercraze
Chromium Software Engineering LetterCraze Project

Your wonderful contributors are:
Griffin Bishop
Gabrielle O'Dell
Batu Sipka
Andrew Vanner
Ian Vossoughi

The GitHub repository is at https://github.com/IanVossoughi/lettercraze/

** HOW TO PLAY **
Run Main.java in src/playerBounday to begin.
You will first be greeted by the splash screen, press continue.
You are now at the main menu to select a level. Only level 1 can 
be played right now. The level number is determined by the selected panel.
Press "Play" to begin the level.
When you return, your score and progressed will be saved.
To reset all progress, exit the entire program and run Main.java again

== Level Types ==

- All Levels -
The three level types have different properties. All levels are won by
making words from tiles. You can click any tile at first then click 
any tile above, below, left, right, or diagonally from that tile to build 
a word. You may then submit that word or deselect the tiles at any times.
The goal is to earn at least one star to advance to the next level.
Whenever you want, you may reset or exit the game and return to the menu.
If at least one star is earned upon exiting, the next level is available to play. 
A star will show the required score and turn yellow when earned.

- Puzzle - 
The most basic type. Click tiles to make words that are in the dictionary. 
Score is determined by the letters in the word and the length of the word. 
Less common letters award more points. The points were determined
from the letterFrequency document provided by the professor.
The exact formula for points is: Sum(LetterPoints) * (LengthOfWord - 2)
The minimum word length is three letters. There is also a limit to the number 
of words that can be submitted. Therefore, the best strategy for harder levels 
would be to try and make long words.

- Lightning -
There is a time limit in this level. 
The score is determined by number of words found.
You may still undo moves or reset the game, but the timer will not stop.
The best strategy for harder levels is to spell short easy words.

- Theme -
Theme level has no time limit and no word limit.
You have to find certain words which are usually given as a clue in the title 
of the level. If the words cannot be determined, check the file in the levels 
folder of the project. Sometimes words will become unavailable depending on 
the word order, so get used to using the undo button.


** HOW TO BUILD **
Run builderMain.java in src/builderBounday to begin.

You will first be greeted by the splash screen, press continue. Most of the Builder 
features are made clear by the GUI.

For Puzzle and Lightning levels, green tiles are active and
can be clicked to become inactive white tiles.

For theme levels, once the list of words is made, press "Generate" to create a board 
configuration. This will not be possible if the number of active tiles is less than 
the number of letters in all the words. For star scores, it is recommended to make 
the 3 Star score the total number of theme words.
# Connect 4

### Overview
------------------
Two users will play against each other in a game of Connect 4. The objective of the game is to place your chips in a way that you will have four in a row, while also making sure your opponent doesn’t get four in a row. The four consecutive chips can be vertical, horizontal, or diagonal. The user with the black chips will always go first. The users take turns placing chips until one has four consecutive chips, or until the board is full. Whichever player gets four consecutive chips first wins. If the board is filled before any player achieves that, the game is a tie.

### Motivation
------------------
This is a project for my CSCI 2300 - Object Oriented Software Design course at Saint Louis University. It was developed by Thomas McGuigan (me), Katherine Sweet, and Robert Lanier.

### Functional Requirements
------------------
FR1: At the start of the game, two players enter a username to be either the red or black circular chips.

FR2: The board is a grid (6x7) of circular chip-holders totalling 42 possible locations for chips. 

FR3: Chips can only be placed on the bottom-most location of the grid, building up as the game play continues.

FR4: The player who receives red chips makes the first play, choosing which location (which column) to place a chip, and the chip falls to the bottom-most open location in that column.

FR5: Play goes back and forth, so only one chip can be placed per turn for each user.

FR6: When a column is full, players cannot place new chips in that column.

FR7: When one player obtains four chips in a consecutive line (vertical, horizontal, or diagonal), play ends and the winner is announced and the four-chip line is bordered/outlined in the display.

FR8: When a player wins, the username for that player is stored in a rankings list (the rankings count the top 3 users with the most wins).

### User Interface Requirements
------------------
UIR1: When the user clicks on the place button below any column, FR3 is executed

UIR2: When all spots in a column are full, then the place button for that column is deactivated (see FR6).

UIR3: Before the game, a window pops up with spots to enter two usernames (see FR1) and shows past winners with win amounts (see FR8).

UIR4: At the start of the game, the board is empty and all column buttons are enabled.

### Required to Run
------------------
- JDK
- Gradle

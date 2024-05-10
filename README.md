# Risk Game 

### 1. Game Description

Risk is a strategy board game of diplomacy, conflict and conquest for two to six players. The standard version is played on a board depicting a political map of the world, divided into 42 territories, which are grouped into six continents. Turns rotate among players who control armies of playing pieces with which they attempt to capture territories from other players, with results determined by dice rolls. The goal of the game is to occupy every territory on the board and, in doing so, eliminate the other players.

### 2. Implementation
This version of the game is implemented in Java. It is designed to be played by only four players and consists of 5 turns, excluding the turn where players set their initial armies. The game ends if all territories have been conquered or the game reaches the 5-turn limit.

The game also adds Action Cards to the default deck, which can be played at different times during invasion or at the end of the turn. (the play method for action cards is not currently implemented).

### 2.1. Design of the project

1. <b>Card</b>: An encompassing Card class that represents all cards in the game.
2.  <b>ActionCard</b>: Represents the action cards in the Risk game.
3.  <b>ArmyCard</b>: Represents the army cards in the Risk game.
4.  <b>ArmyPiece</b>: Represents the army pieces in the Risk game.
5.  <b>Deck</b>: Represents the Deck of the game.
6.  <b>Continent</b>: Represents the continents in the game.
7.  <b>Territory</b>: Represents the 42 territories in the game.
8.  <b>Player</b>: Represents a single player of the game.
9.  <b>Game</b>: Represents the game of Risk.
10.  <b>GameConsole</b>: Represents the game's UI.

### 2.2. Assumptions
1. The current version is played using user inputs from the terminal. The game assumes the user input is always structured in the correct order and style.
2. The order of players is decided by dice roll, in descending order.
3. The bonus troop feature is not implemented.
4. Players can only attack once during the turn. The attack continues until there are no more eligible armies to send or when the attacking player conquers the territory. 
5. Action card play methods are not currently implemented
6. Whitespaces in territory names are not supported (United States should be inputted as UnitedStates).
7. Sample gameplay: https://docs.google.com/document/d/1UkgLcRqF9bToNu3cQ-GQtzXI3wY1X5oVfWCY8zIiRn8/

![image](https://github.com/NunuArabian/OOP-Group-assignment-/assets/162872072/6da38377-4c53-4b6c-a042-2033b3280d98)






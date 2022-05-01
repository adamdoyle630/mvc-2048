package model;

public interface Model {

  /** Shifts cells down on the board */
  void moveDown();

  /** Shifts cells up on the board */
  void moveUp();

  /** Shifts cells left on the board */
  void moveLeft();

  /** Shifts cells right on the board */
  void moveRight();

  /** Gets the numerical value of tile at row r, column c */
  int getTileValue(int r, int c);

  /** Updates the scoreboard */
  void updateScoreboard();

  /**  Returns whether the puzzle has been solved */
  boolean isSolved();

  /** Determines whether the game has ended */
  boolean gameOver();

  /** Adds an observer to the list of observers */
  void addObserver(ModelObserver o);

  /** Removes an observer from the list of observers */
  void removeObserver(ModelObserver o);

}
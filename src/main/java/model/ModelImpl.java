package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelImpl implements Model {

  private final int[][] board;
  public final int BOARD_SIZE = 4;
  private int currentScore;
  private int bestScore;
  private boolean isSolved;
  private final List<ModelObserver> observers = new ArrayList<>();

  public ModelImpl() {
    this.board = new int[BOARD_SIZE][BOARD_SIZE];
    resetBoard();
    printBoard();
  }

  @Override
  public void moveDown() {

  }

  @Override
  public void moveUp() {

  }

  @Override
  public void moveLeft() {

  }

  @Override
  public void moveRight() {

  }

  @Override
  public int getTileValue(int r, int c) {
    return board[r][c];
  }

  @Override
  public void updateScoreboard() {

  }

  @Override
  public boolean isSolved() {
    return false;
  }

  @Override
  public boolean gameOver() {
    return false;
  }

  @Override
  public void addObserver(ModelObserver o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(ModelObserver o) {
    observers.remove(o);
  }
  private void resetBoard() {
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        board[r][c] = 0;
      }
    }
    board[0][1] = 2;
    board[0][3] = 4;
    board[3][2] = 2;
  }

  private void printBoard() {
    for (int[] ints : board) {
      System.out.print("[");
      for (int i = 0; i < board[0].length; i++) {
        System.out.print(" " + ints[i] + " ");
      }
      System.out.print("]\n");
    }
  }

  private void notifyObservers() {
    for (ModelObserver o : this.observers) {
      o.update(this);
    }
  }
}

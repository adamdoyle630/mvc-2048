package controller;

public interface Controller {

  void swipeLeft();

  void swipeRight();

  void swipeUp();

  void swipeDown();

  int getTileValue(int r, int c);

}

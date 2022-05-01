package controller;

import model.Model;

public class ControllerImpl implements Controller {

  private final Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public void swipeLeft() {
    model.moveLeft();
  }

  @Override
  public void swipeRight() {
    model.moveRight();
  }

  @Override
  public void swipeUp() {
    model.moveUp();
  }

  @Override
  public void swipeDown() {
    model.moveDown();
  }

  @Override
  public int getTileValue(int r, int c) {
    return model.getTileValue(r, c);
  }
}

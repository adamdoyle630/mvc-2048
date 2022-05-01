package view;

import controller.Controller;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import model.Model;
import model.ModelImpl;

public class AppView implements FXComponent {

  private Controller controller;

  public AppView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    // Create new Pane objects to hold the UI components
    Pane layout = new VBox();
    layout.getStyleClass().add("layout");

    // The scoreboard goes at the top of the board
    Pane scoreboard = new HBox();
    scoreboard.getStyleClass().add("scoreboard");
    layout.getChildren().add(scoreboard);

    // The scoreboard has a logo
    Pane logoContainer = new HBox();
    Label logo = new Label("2048");
    logo.getStyleClass().add("logo");
    logoContainer.getChildren().add(logo);
    HBox.setHgrow(logoContainer, Priority.ALWAYS);
    scoreboard.getChildren().add(logoContainer);

    // The scoreboard shows the current score
    Pane score = new VBox();
    score.getStyleClass().add("score");
    Label scoreLabel = new Label("SCORE");
    scoreLabel.getStyleClass().add("score-label");
    score.getChildren().add(scoreLabel);
    Label scoreValue = new Label("2268");
    scoreValue.getStyleClass().add("score-value");
    score.getChildren().add(scoreValue);
    scoreboard.getChildren().add(score);

    // The scoreboard also shows the best score
    Pane best = new VBox();
    best.getStyleClass().add("score");
    Label bestLabel = new Label("BEST");
    bestLabel.getStyleClass().add("score-label");
    best.getChildren().add(bestLabel);
    Label bestValue = new Label("2268");
    bestValue.getStyleClass().add("score-value");
    best.getChildren().add(bestValue);
    scoreboard.getChildren().add(best);

    // Add the instructions to the layout
    Label instructions = new Label("Join the numbers and get to the 2048 tile!");
    instructions.getStyleClass().add("instructions");
    layout.getChildren().add(instructions);

    // The game board goes at the bottom of the layout
    GridPane board = new GridPane();
    board.setHgap(10);
    board.setVgap(10);
    board.getStyleClass().add("board");
    layout.getChildren().add(board);

    // Fill up the board with tiles
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        board.add(makeTile(controller.getTileValue(i, j)), j, i);
      }
    }
    /*board.add(makeTile(0), 0, 0);
    board.add(makeTile(2), 1, 0);
    board.add(makeTile(8), 2, 0);
    board.add(makeTile(4), 3, 0);
    board.add(makeTile(16), 0, 1);
    board.add(makeTile(64), 1, 1);
    board.add(makeTile(4), 2, 1);
    board.add(makeTile(2), 3, 1);
    board.add(makeTile(8), 0, 2);
    board.add(makeTile(4), 1, 2);
    board.add(makeTile(32), 2, 2);
    board.add(makeTile(4), 3, 2);
    board.add(makeTile(2), 0, 3);
    board.add(makeTile(2048), 1, 3);
    board.add(makeTile(8), 2 ,3);
    board.add(makeTile(2), 3, 3);*/
    return layout;
  }

  private static Label makeTile(int num) {
    Label tile;
    if (num == 0) {
      tile = new Label();
    } else {
      tile = new Label(String.valueOf(num));
    }
    tile.getStyleClass().add("tile");
    tile.getStyleClass().add("tile-" + num);
    return tile;
  }
}

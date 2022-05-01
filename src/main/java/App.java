import controller.Controller;
import controller.ControllerImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import model.ModelImpl;
import view.AppView;
import view.FXComponent;

public class App extends Application {
  public void start(Stage stage) {

    // Model view controller
    Model model = new ModelImpl();
    Controller controller = new ControllerImpl(model);
    FXComponent view = new AppView(controller);

    // Make scene
    Scene scene = new Scene(view.render(), 430, 600);
    scene.getStylesheets().add("main.css");
    stage.setScene(scene);

    // Refresh view when model changes
    model.addObserver(
        (Model m) -> {
          scene.setRoot(view.render());
          stage.sizeToScene();
        });

    stage.setTitle("Play 2048");
    stage.setScene(scene);
    stage.show();
  }
}

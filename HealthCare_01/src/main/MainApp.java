package main;

import java.util.HashMap;
import java.util.Map;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import views.LoginController;
import views.RegisterController;
import views.RootController;

public class MainApp extends Application {

	public static MainApp app;
	private StackPane mainPage;

	Pane pane;

	private Map<String, RootController> controllerMap = new HashMap<>();

	@Override
	public void start(Stage primaryStage) {

		app = this;

		// primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setResizable(false);

		try {
			FXMLLoader mainLoader = new FXMLLoader();
			mainLoader.setLocation(getClass().getResource("/views/MainLayout.fxml"));
			mainPage = mainLoader.load();

			RootController mc = mainLoader.getController();
			mc.setRoot(mainPage);
			controllerMap.put("mainPage", mc);

			FXMLLoader loginLoader = new FXMLLoader();
			loginLoader.setLocation(getClass().getResource("/views/LoginLayout.fxml"));
			AnchorPane loginPage = loginLoader.load();

			// 로그인 컨트롤러를 가져와서 컨트롤러 맵에 넣는다.
			LoginController lc = loginLoader.getController();
			lc.setRoot(loginPage);
			controllerMap.put("login", lc);

			FXMLLoader registerLoader = new FXMLLoader();
			registerLoader.setLocation(getClass().getResource("/views/RegisterLayout.fxml"));
			AnchorPane registerPage = registerLoader.load();

			RegisterController rc = registerLoader.getController();
			rc.setRoot(registerPage);
			controllerMap.put("register", rc);

			Scene scene = new Scene(mainPage);
			mainPage.getChildren().add(loginPage);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	// 지정한 페이지를 로딩하는 것
	public void loadPane(String name) {
		// 지정한 컨트롤러를 맵에서 꺼낸다.
		RootController c = controllerMap.get(name);
		pane = c.getRoot();
		mainPage.getChildren().add(pane);
	}

	public void slide(Pane pane) {
		Timeline timeline = new Timeline();
		KeyValue toRight = new KeyValue(pane.translateYProperty(), 800);
		KeyValue fadeOut = new KeyValue(pane.opacityProperty(), 0);

		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), (e) -> {
			mainPage.getChildren().remove(pane);
		}, toRight, fadeOut);

		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}
}
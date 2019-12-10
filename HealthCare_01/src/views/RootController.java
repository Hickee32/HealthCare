package views;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class RootController {

	static String UserLoginName = null;
	static int Logincheck = 2;

	private Pane root;
	@FXML
	private AnchorPane AmountExPage;
	@FXML
	private Button AmountExBTn;
	@FXML
	private StackPane mainContent;
	@FXML
	Label TextLabel;
	@FXML
	Button LogBtn;

	public Pane getRoot() {
		return root;
	}

	public void setRoot(Pane root) {
		this.root = root;
	}

	public void AmountExPage() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AmountExLayout.fxml"));
		Pane AmountExPane = (Pane) fxmlLoader.load();
		try {
			mainContent.getChildren().clear();
			mainContent.getChildren().add(AmountExPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CalendarPage() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CalendarLayout.fxml"));
		Pane CalendarPane = (Pane) fxmlLoader.load();
		try {
			mainContent.getChildren().clear();
			mainContent.getChildren().add(CalendarPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AmountFoodPage() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AmountFoodLayout.fxml"));
		Pane AmountFoodPane = (Pane) fxmlLoader.load();
		try {
			mainContent.getChildren().clear();
			mainContent.getChildren().add(AmountFoodPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GraphPage() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/GraphLayout.fxml"));
		Pane GraphPane = (Pane) fxmlLoader.load();
		try {
			mainContent.getChildren().clear();
			mainContent.getChildren().add(GraphPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void MemoPage() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/MemoLayout.fxml"));
		Pane AmountExPane = (Pane) fxmlLoader.load();
		try {
			mainContent.getChildren().clear();
			mainContent.getChildren().add(AmountExPane);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void LogbtnTextChange() {
		if (Logincheck == 0) {
			LogBtn.setText("Logout");
		} else if (Logincheck == 1) {
			LogBtn.setText("Login");
		} else {
			LogBtn.setText("Register");
		}
	}

	public void AmountExEntered() {
		TextLabel.setText("����� ����մϴ�");
	}

	public void AmountFoodEntered() {
		TextLabel.setText("Į�θ��� ����մϴ�.");
	}

	public void CalendarEntered() {
		TextLabel.setText("���ں� ���뷮 ����� Ȯ���մϴ�.");
	}

	public void GraphEntered() {
		TextLabel.setText("�׷����� ǥ�õ˴ϴ�.");
	}

	public void MemoEntered() {
		TextLabel.setText("������ ������ ǥ���մϴ�.");
	}

	public void MainbtnEntered() {
		TextLabel.setText("�������� ���ư���");
	}

	public void EndBtnEntered() {
		TextLabel.setText("�����մϴ�.");
	}

	public void BtnExited() {
		TextLabel.setText("�������");
	}

	public static String getUserLoginName() {
		return UserLoginName;
	}

	public static void setUserLoginName(String userLoginName) {
		UserLoginName = userLoginName;

	}

}

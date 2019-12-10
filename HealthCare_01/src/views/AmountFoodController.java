package views;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import resource.Food;

public class AmountFoodController extends RootController {

	@SuppressWarnings("rawtypes")
	@FXML
	private ComboBox foodCB;
	@FXML
	private TableView<Food> foodBF;
	@FXML
	private TableView<Food> foodAF;

	private ObservableList<String> comBolist = FXCollections.observableArrayList("����", "��", "��");
	ObservableList<Food> FoodList;
	ObservableList<Food> FoodAddedList;

	String FoodName;
	double Foodkcal;

	@SuppressWarnings("unchecked")
	@FXML
	private void initialize() {
		foodCB.setItems(comBolist);
		foodCB.getSelectionModel().select(0);
		foodAF.setPlaceholder(new Label("���� ������ �߰����ּ���"));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void GukListadd() {
		FoodList = FXCollections.observableArrayList(new Food("�̿���", 204.0), new Food("���ߵ��屹", 73.0),
				new Food("���ⱹ", 234.0), new Food("�Ͼ", 272.0), new Food("���⹫��", 110.0), new Food("�ñ�ġ���屹", 73.0),
				new Food("�÷�����屹", 67.0), new Food("�ƿ�", 84.0), new Food("���", 97.0), new Food("�������", 203.0),
				new Food("�ᳪ����", 43.0), new Food("������", 569.0), new Food("������", 75.0), new Food("������", 240.0));

		TableColumn tcFood = foodBF.getColumns().get(0);
		tcFood.setCellValueFactory(new PropertyValueFactory("FoodName"));
		TableColumn tcFkal = foodBF.getColumns().get(1);
		tcFkal.setCellValueFactory(new PropertyValueFactory("FoodKcal"));

		foodBF.setItems(FoodList);

		foodBF.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
			@Override
			public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
				if (newValue != null) {
					Food model = foodBF.getSelectionModel().getSelectedItem();
					System.out.println("�� : " + model.getFoodName());
					System.out.println("Į�θ� : " + model.getFoodKcal());
					FoodName = model.getFoodName();
					Foodkcal = model.getFoodKcal();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void BabListadd() {
		FoodList = FXCollections.observableArrayList(new Food("�̱�", 204.0), new Food("���ߵ��屹", 73.0),
				new Food("���ⱹ", 234.0), new Food("�Ͼ", 272.0), new Food("���⹫��", 110.0), new Food("�ñ�ġ���屹", 73.0),
				new Food("�÷�����屹", 67.0), new Food("�ƿ�", 84.0), new Food("���", 97.0), new Food("�������", 203.0),
				new Food("�ᳪ����", 43.0), new Food("������", 569.0), new Food("������", 75.0), new Food("������", 240.0));

		TableColumn tcFood = foodBF.getColumns().get(0);
		tcFood.setCellValueFactory(new PropertyValueFactory("FoodName"));
		TableColumn tcFkal = foodBF.getColumns().get(1);
		tcFkal.setCellValueFactory(new PropertyValueFactory("FoodKcal"));

		foodBF.setItems(FoodList);

		foodBF.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Food>() {
			@Override
			public void changed(ObservableValue<? extends Food> observable, Food oldValue, Food newValue) {
				if (newValue != null) {
					Food model = foodBF.getSelectionModel().getSelectedItem();
					System.out.println("�� : " + model.getFoodName());
					System.out.println("Į�θ� : " + model.getFoodKcal());
					FoodName = model.getFoodName();
					Foodkcal = model.getFoodKcal();
				}
			}
		});
	}

	public void handlefoodCB(ActionEvent event) {
		if (foodCB.getValue().equals("��")) {
			BabListadd();
		} else if (foodCB.getValue().equals("��")) {
			GukListadd();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void AddfoodAF() {

		foodAF.refresh();

		FoodAddedList.add(new Food(FoodName, Foodkcal));

		TableColumn foodName = foodAF.getColumns().get(0);
		foodName.setCellValueFactory(new PropertyValueFactory("FoodName"));
		TableColumn foodKcal = foodAF.getColumns().get(1);
		foodKcal.setCellValueFactory(new PropertyValueFactory("Foodkcal"));

		foodAF.setItems(FoodAddedList);
	}
}

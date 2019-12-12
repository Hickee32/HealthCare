package views;


import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class GraphController extends MainController {

	@FXML
	private BarChart barChart;
	@FXML
	private Button StartBtn;

	@FXML
	private void initialize() {
		ChartStart();
	}

	public void ChartStart() {

//		CategoryAxis xAxis = new CategoryAxis();
//		xAxis.setLabel("---1---");
//		NumberAxis yAxis = new NumberAxis();
//		yAxis.setLabel("---2---");
//
//		barChart = new BarChart(xAxis, yAxis);
//
//		XYChart.Series dataseries1 = new XYChart.Series();
//		dataseries1.setName("---3---");
//
//		dataseries1.getData().add(new XYChart.Data("A", 70));
//		dataseries1.getData().add(new XYChart.Data("B", 50));
//		dataseries1.getData().add(new XYChart.Data("C", 30));
//
//		barChart.getData().add(dataseries1);
		XYChart.Series dataSeries1 = new XYChart.Series();
		dataSeries1.setName("Weight");

		dataSeries1.getData().add(new XYChart.Data("1", 567));
		dataSeries1.getData().add(new XYChart.Data("2"  , 65));
		dataSeries1.getData().add(new XYChart.Data("3"  , 23));

		barChart.getData().add(dataSeries1);

		XYChart.Series dataSeries2 = new XYChart.Series();
		dataSeries2.setName("Height");

		dataSeries2.getData().add(new XYChart.Data("1", 540));
		dataSeries2.getData().add(new XYChart.Data("2"  , 120));
		dataSeries2.getData().add(new XYChart.Data("3"  , 36));

		barChart.getData().add(dataSeries2);
		
		XYChart.Series dataSeries3 = new XYChart.Series();
		dataSeries3.setName("Bmi");

		dataSeries3.getData().add(new XYChart.Data("1", 540));
		dataSeries3.getData().add(new XYChart.Data("2"  , 120));
		dataSeries3.getData().add(new XYChart.Data("3"  , 36));

		barChart.getData().add(dataSeries3);
		

	}

}

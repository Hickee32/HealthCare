package views;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DayController extends MainController {
	@FXML
	private Label lblDay;

	@SuppressWarnings("unused")
	private LocalDate date;

	@SuppressWarnings("unused")
	private boolean isFocused = false;

	public void setDayLabel(LocalDate date) {
		this.date = date;
		lblDay.setText(String.valueOf(date.getDayOfMonth()));
	}

}

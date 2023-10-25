package es.yorman.dad.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

	// view
	
	private TextField findF, replaceF;
	private CheckBox mayusMinusCB, buscarAtrasCB, regexCB, resaltarResultsCB;
	private Button searchButton, replaceButton, replaceAllButton, closeButton, helpButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// view
		findF = new TextField();
		replaceF = new TextField();
		
		mayusMinusCB = new CheckBox("Mayúsculas y minúsculas");
		buscarAtrasCB = new CheckBox("Buscar hacia atrás");
		regexCB = new CheckBox("Expresión regular");
		resaltarResultsCB = new CheckBox("Resaltar resultados");
		
		searchButton = new Button("Buscar");
		replaceButton = new Button("Reemplazar");
		replaceAllButton = new Button("Reemplazar todo");
		closeButton = new Button("Cerrar");
		helpButton = new Button("Ayuda");
		
		searchButton.setMaxWidth(Double.MAX_VALUE);
		replaceButton.setMaxWidth(Double.MAX_VALUE);
		replaceAllButton.setMaxWidth(Double.MAX_VALUE);
		closeButton.setMaxWidth(Double.MAX_VALUE);
		helpButton.setMaxWidth(Double.MAX_VALUE);
		
		GridPane checkBox = new GridPane();
		checkBox.setVgap(5);
		checkBox.setHgap(5);
		checkBox.addRow(0, mayusMinusCB, buscarAtrasCB);
		checkBox.addRow(1, regexCB, resaltarResultsCB);
		
		ColumnConstraints [] colsCB = {
			new ColumnConstraints(),
			new ColumnConstraints(),
		};
		checkBox.getColumnConstraints().setAll(colsCB);
		
		colsCB[0].setHgrow(Priority.ALWAYS);
		colsCB[1].setHgrow(Priority.ALWAYS);
		
		VBox rightPanel = new VBox(5, searchButton, replaceButton, replaceAllButton, closeButton, helpButton);
		rightPanel.setPadding(new Insets(0, 0, 0, 5));
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(5));
		root.setVgap(5);
		root.setHgap(5);
		root.addRow(0, new Label("Buscar:"), findF, rightPanel);
		root.addRow(1, new Label("Reemplazar con:"), replaceF);
		root.add(checkBox, 1, 2);
		GridPane.setRowSpan(rightPanel, 3);
		
		ColumnConstraints [] cols = {
			new ColumnConstraints(),
			new ColumnConstraints(),
			new ColumnConstraints()
		};
		root.getColumnConstraints().setAll(cols);
		
		cols[1].setHgrow(Priority.ALWAYS);
		cols[1].setFillWidth(true);

		Scene scene = new Scene(root, 540, 200);
		primaryStage.setTitle("Buscar y reemplazar");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

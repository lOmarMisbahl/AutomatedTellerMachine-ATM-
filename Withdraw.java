import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Withdraw {

    public static Label label1;
    public static Label label2;

    public static void display(String title) {

        label2= new Label("Successful Withdraw");
        label2.setVisible(false);
        label1 = new Label("Unvalid value");
        label1.setVisible(false);
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label("Amount to Withdraw : ");
        TextField textField = new TextField();
        Button button1 = new Button("Withdarw");
        button1.setOnAction(e -> {
            label1.setVisible(false);
            label2.setVisible(false);
            isDouble(textField.getText());
        });
        Button button2 = new Button("Close");
        button2.setOnAction(e -> primaryStage.close());
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.getChildren().addAll(label, textField, button1, button2,label1,label2);
        GridPane.setConstraints(label, 0, 0);
        GridPane.setConstraints(textField, 1, 0);
        GridPane.setConstraints(button1, 0, 1);
        GridPane.setConstraints(button2, 1, 1);
        GridPane.setConstraints(label1,0,2);
        GridPane.setConstraints(label2,0,2);
        Scene scene = new Scene(layout, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.showAndWait();
    }

    public static void isDouble(String Entry) {
        try {
            double input = Double.parseDouble(Entry);
            if (!GUI.myBankAccount.withdraw(input))
                label1.setVisible(true);
            else {
                label2.setVisible(true);
            }
        } catch (NumberFormatException e) {
            label1.setVisible(true);
        }
    }
}

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GUI extends Application {

    public static BankAccount myBankAccount = new BankAccount(1234,70.0);
    static Stage window1;
    Stage window2;
    Stage window3;
    Scene scene1;
    static Scene scene2;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    static Label label;
    Label label1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window1=primaryStage;
        window1.setTitle("ATM");
        label = new Label("Incorrect Password");
        label.setVisible(false);


        TextField txt1 = new TextField("YourCardNumber");
        txt1.setDisable(true);
        PasswordField txt2 = new PasswordField();
        txt2.setPromptText("EnterYourPassword");
        button4=new Button("Log In");
        button4.setOnAction(e -> validate(txt2.getText())
        );
        GridPane layout1 = new GridPane();
        layout1.setPadding(new Insets(10,10,10,10));
        layout1.setVgap(10);
        layout1.setHgap(10);
        layout1.getChildren().addAll(txt1,txt2,button4,label);
        GridPane.setConstraints(txt1,0,0);
        GridPane.setConstraints(txt2,0,1);
        GridPane.setConstraints(button4,0,2);
        GridPane.setConstraints(label,0,3);

        scene1 = new Scene(layout1,400,400);

        label1 = new Label();
        label1.setVisible(false);

        button1 = new Button("Balance");
        button1.setOnAction(e -> {
            label1.setVisible(true);
            label1.setText("Your Current Balance : "+myBankAccount.getBalance());
                }
        );
        button2 = new Button("Deposit");
        button2.setOnAction(e -> {
            label1.setVisible(false);
            Deposit.show("Deposit");
        });
        button3 = new Button("Withdraw");
        button3.setOnAction(e -> {
            label1.setVisible(false);
            Withdraw.display("Withdraw");
        });
        button5= new Button("Close");
        button5.setOnAction(e -> window1.close());


        BorderPane layout3 = new BorderPane();
        layout3.setPadding(new Insets(10,10,10,10));
        VBox layout2 = new VBox(10);
        layout2.setPadding(new Insets(10,10,10,10));
        layout2.getChildren().addAll(button2,button3);
        layout3.setLeft(layout2);
        VBox layout4 = new VBox(10);
        layout4.setPadding(new Insets(10,10,10,10));
        layout4.getChildren().addAll(button1,button5);
        layout3.setRight(layout4);
        layout3.setBottom(label1);
        scene2 = new Scene(layout3,400,400);
        window1.setScene(scene1);
        window1.show();

    }

    public static void validate(String Entry){
        try{
            int number = Integer.parseInt(Entry);
            if (number == 1234)
                window1.setScene(scene2);
            else
                label.setVisible(true);
        }catch (NumberFormatException e){
            label.setVisible(true);
        }
    }
}

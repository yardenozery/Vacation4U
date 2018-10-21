package View;

import Model.model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        //launch(args);
        model m = new model();
        //m.CreateNewUser("alon123", "123456", "5/12/94", "alon", "fat", "ness ziona");
        //m.CreateNewUser("aa", "123456", "5/12/94", "alon", "fat", "ness ziona");
        //String[] a = m.ReadUser("aa");
        //for(int i=0; i<a.length; i++){
        //    System.out.println(a[i]);
        //}
        //m.UpdateUser("aa", "12345678", "5/12/94", "alon", "fat", "ness ziona");
        //m.DeleteUser("aa");

    }
}

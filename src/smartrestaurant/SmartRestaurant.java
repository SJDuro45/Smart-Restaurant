/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartrestaurant;


import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;


/**
 *
 * @author Stephan Duroseau
 */
public class SmartRestaurant extends Application {
    ArrayList<Dish> plates = new ArrayList<>();
    String name = "", 
            description = "", 
            picture = "", 
            price = "0.0";
    static int idx = 0;
    static ArrayList<Scene> frame = new ArrayList<>();
    static ArrayList<GridPane> layout = new ArrayList<>();
    
    @Override
    public void start(Stage primaryStage) {
        try{
            Scanner s = new Scanner(getClass().getResourceAsStream("/resources/config.txt"));
            
            while(s.hasNextLine()){
                name = s.nextLine().substring(6);
                System.out.println(name);
                description = s.nextLine().substring(13);
                System.out.println(description);
                picture = s.nextLine().substring(9);
                System.out.println(picture);
                price = s.nextLine().substring(7);
                System.out.println(price);
                
                Dish entree = new Dish(name, description, picture, price);
                plates.add(entree);         
            }
            
            for(int i = 0; i < plates.size(); i++){
                GridPane grd = new GridPane();
                Dish plate = new Dish();
                plate = plates.get(i);
                
                Text plateName = new Text(plate.getName());
                //grd.add(plateName, 0, 0, 3, 3);
                grd.add(plateName, 0, 0);
                plateName.setFont(Font.font("Comic Sans", FontWeight.BOLD, FontPosture.REGULAR, 40));
                plateName.setFill(Color.GREEN);
                plateName.setStroke(Color.AQUAMARINE);
                plateName.setStrokeWidth(1);
                plateName.setUnderline(true);
                        
                Label plateDesc = new Label(plate.getDescription());
                plateDesc.setWrapText(true);
                grd.add(plateDesc, 1, 3);
                
                Label platePrice = new Label(plate.getPrice());
                grd.add(platePrice, 1, 4);
                
                ImageView imv = new ImageView();
                Image pc = new Image(plate.getPicture());
                System.out.println("picture loaded");
                imv.setImage(pc);
                imv.setFitHeight(300);
                imv.setFitWidth(300);
                grd.add(imv, 0, 3);
                
                Button nxtBtn = new Button("Next ->");
                grd.add(nxtBtn, 1, 5);
                Button prvBtn = new Button("<- Prev");
                grd.add(prvBtn, 0, 5);
                
                nxtBtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        if(idx != plates.size()-1){
                            idx++;
                            
                            primaryStage.setScene(frame.get(idx));
                            primaryStage.show();
                        }
                        else {
                            idx = 0;
                            
                            primaryStage.setScene(frame.get(idx));
                            primaryStage.show();
                        }
                    }
            });
                prvBtn.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        if(idx != 0){
                            idx--;
                            
                            primaryStage.setScene(frame.get(idx));
                            primaryStage.show();
                        } 
                        else {
                            idx = plates.size()-1;
                            
                            primaryStage.setScene(frame.get(idx));
                            primaryStage.show();
                        }
                    }
                });
                layout.add(grd);
                frame.add(new Scene(layout.get(i), 500, 400));
            }
            primaryStage.setTitle("Smart Restaurant Menu");
            
            primaryStage.setScene(frame.get(0));
            primaryStage.show();
        } catch(Exception x) {
            System.out.println("Exception: " + x + " Caught");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

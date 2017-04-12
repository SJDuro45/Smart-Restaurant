/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartrestaurant;

/**
 *
 * @author Stephan Duroseau
 */
public class Dish {
    String name, description, picture, price;
    
    public Dish(String n, String d, String p, String pr){
        this.name = n;
        this.description = d;
        this.picture = p;
        this.price = pr;
    }
    
   public Dish(){
       name = "";
       description = "";
       picture = "";
       price = "0.0";
   }
   
   public String getName(){
       return this.name;
   }
   
   public String getDescription(){
       return this.description;
   }
   
   public String getPicture(){
       return this.picture;
   }
   
   public String getPrice(){
       return this.price;
   }
}

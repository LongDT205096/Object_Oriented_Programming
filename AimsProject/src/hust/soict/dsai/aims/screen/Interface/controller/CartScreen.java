package hust.soict.dsai.aims.screen.Interface.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    public CartScreen(Cart cart){
        super();

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass().
                                        getResource("/hust/soict/dsai/aims/screen/Interface/view/cart.fxml"));
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void main(String[] args){
        Cart cart = new Cart();
        DigitalVideoDisc dvd_1 = new DigitalVideoDisc("The Lion King", "Animation",
				19.95f, 87, "Roger Allers");
            cart.addMedia(dvd_1);
        CompactDisc cd_1 = new CompactDisc("Famous Friends", "Music", 
                14.97f, 90, null, "Chris");
            cart.addMedia(cd_1);

        new CartScreen(cart);
    }
}

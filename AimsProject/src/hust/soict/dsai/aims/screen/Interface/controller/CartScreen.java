package hust.soict.dsai.aims.screen.Interface.controller;

import hust.soict.dsai.aims.cart.Cart;

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
}

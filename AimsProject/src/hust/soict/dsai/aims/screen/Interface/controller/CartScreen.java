package hust.soict.dsai.aims.screen.Interface.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store.Store;

import java.io.IOException;
import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
    private Cart cart;
    private Store store;
    
    public CartScreen(Store store, Cart cart){
        this.cart = cart;
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Cart");
        this.setVisible(true);
        
        Platform.runLater(new Runnable() {
            @Override
            public void run(){
                try{
                    FXMLLoader loader = new FXMLLoader(getClass()
                                            .getResource("/hust/soict/dsai/aims/screen/Interface/view/cart.fxml"));
                    loader.setController(new CartScreenController(store, cart));
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}

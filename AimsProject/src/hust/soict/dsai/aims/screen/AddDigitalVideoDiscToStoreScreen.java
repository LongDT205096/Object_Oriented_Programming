package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart){
        super(store, cart);

        JPanel lengthPanel = super.createSubPanel("Length");
        JPanel directorPanel = super.createSubPanel("Director");

        super.centerPanel.add(directorPanel, BorderLayout.CENTER);
		super.centerPanel.add(lengthPanel, BorderLayout.CENTER);

        btnAdd.addActionListener(new btnAddingListener());

        super.setTitle("Add DVD");
    }

    private class btnAddingListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = null, category = null, director = null;
            float cost = 0;
            int length = 0;

            for(JTextField tf: tfs){
                if(tf.getName().equals("Title")){
                    title = tf.getText();
                } else if(tf.getName().equals("Category")){
                    category = tf.getText();
                } else if(tf.getName().equals("Director")){
                    director = tf.getText();
                } else if(tf.getName().equals("Cost")){
                    cost = Float.parseFloat(tf.getText());
                } else if(tf.getName().equals("Length")){
                    length = Integer.parseInt(tf.getText());
                }
            }

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
			store.addMedia(dvd);
            JOptionPane.showMessageDialog(null, "Adding successful");
        }
    }
}
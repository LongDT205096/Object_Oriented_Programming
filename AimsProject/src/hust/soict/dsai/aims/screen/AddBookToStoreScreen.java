package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);

        JPanel length = super.createSubPanel("Length");
        JPanel authors = super.createSubPanel("Authors");
        super.centerPanel.add(length, BorderLayout.CENTER);
        super.centerPanel.add(authors, BorderLayout.SOUTH);

        btnAdd.addActionListener(new btnAddingListener());
		super.setTitle("Add Book");
    }

    private class btnAddingListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = null, category = null;
            float cost = 0;
            int length = 0;
            ArrayList<String> authorsList = new ArrayList<>();

            for(JTextField tf: tfs){
                if(tf.getName().equals("Title")){
                    title = tf.getText();
                } else if(tf.getName().equals("Category")){
                    category = tf.getText();
                } else if(tf.getName().equals("Length")){
                    length = Integer.parseInt(tf.getText());
                } else if(tf.getName().equals("Authors")){
                    authorsList.add(tf.getText());
                } else if(tf.getName().equals("Cost")){
                    cost = Float.parseFloat(tf.getText());
                }
            }

            Book book = new Book(title, category, cost, authorsList, length);
			store.addMedia(book);
            authorsList.clear();
            JOptionPane.showMessageDialog(null, "Adding successful");
            tfs.clear();
        }
    }
}

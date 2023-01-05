package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AddItemToStoreScreen extends JFrame{
    Store store;
    Cart cart;
    JPanel centerPanel;
	JButton btnAdd;

    ArrayList<JTextField> tfs = new ArrayList<JTextField>();
    
    public AddItemToStoreScreen(Store store, Cart cart){
        this.store = store;
        this.cart = cart;

        setSize(1024, 768);
		setLayout(new BorderLayout());

        add(createMenuBar(), BorderLayout.NORTH);

        centerPanel = createCenter();
        add(centerPanel, BorderLayout.CENTER);

        JPanel addingPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnAdd = new JButton("Add");
        addingPanel.add(btnAdd);
        add(addingPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

	JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JButton viewStore = new JButton("View Store");
        viewStore.addActionListener(new btnActionListener());
        menuBar.add(viewStore);

		return menuBar;
	}

    JPanel createCenter(){
        JPanel centerPanel = new JPanel(new GridLayout(7, 1, 4, 4));
		
		JPanel titlePanel = createSubPanel("Title");
		JPanel categoryPanel = createSubPanel("Category");
		JPanel costPanel = createSubPanel("Cost");
		
		centerPanel.add(titlePanel);
		centerPanel.add(categoryPanel);
		centerPanel.add(costPanel);
		
		return centerPanel;
    }

    JPanel createSubPanel(String text){
        JPanel subPanel = new JPanel(new FlowLayout());
        JTextField tf = new JTextField(50);
        tf.setName(text);
        tfs.add(tf);

        JLabel field = new JLabel(text);
        subPanel.add(field);
        subPanel.add(tf);
        subPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        return subPanel;
    }

    private class btnActionListener implements ActionListener{
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            new StoreScreen(store, cart);
            dispose();
        }
    }
}

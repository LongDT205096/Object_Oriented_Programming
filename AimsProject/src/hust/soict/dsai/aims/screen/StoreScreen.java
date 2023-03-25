package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.Interface.controller.CartScreen;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreScreen extends JFrame{
    private Store store;
    public static Cart cart;

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenu = new JMenuItem("Add Book");
            addBookMenu.addActionListener(new btnMenuListener());
        JMenuItem addDvdMenu = new JMenuItem("Add DVD");
            addDvdMenu.addActionListener(new btnMenuListener());
        JMenuItem addCdMenu = new JMenuItem("Add CD");
            addCdMenu.addActionListener(new btnMenuListener());

        smUpdateStore.add(addBookMenu);
        smUpdateStore.add(addDvdMenu);
        smUpdateStore.add(addCdMenu);
        menu.add(smUpdateStore);
        
        menu.add(new JMenuItem("View store"));

        JMenuItem cart = new JMenuItem("View cart");
        cart.addActionListener(new btnViewCart());
        menu.add(cart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());

        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i=0; i<mediaInStore.size(); i++){
            CellStore cell = new CellStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    private class btnMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            if (command.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen(store, cart);
			} else if (command.equals("Add Book")) {
				new AddBookToStoreScreen(store, cart);
			} else if (command.equals("Add CD")) {
				new AddCompactDiscToStoreScreen(store, cart);
			} else if (command.equals("View Store")) {
				new StoreScreen(store, cart);
			}
			dispose();
		}
    }

    private class btnViewCart implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
            setVisible(false);
			new CartScreen(store, cart);
		}
	}

    public StoreScreen(Store store, Cart cart){
        StoreScreen.cart = cart;
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

}

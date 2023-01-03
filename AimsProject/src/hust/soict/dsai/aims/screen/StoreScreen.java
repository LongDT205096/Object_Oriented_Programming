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
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

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

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 500));
        cart.addActionListener(new viewCart());

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    private class viewCart implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			Container cb = getContentPane();
            cb.setLayout(new BorderLayout());
            cb.add(new CartScreen(cart));
		}
	}

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for(int i=0; i<mediaInStore.size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
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

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
		DigitalVideoDisc dvd_1 = new DigitalVideoDisc("The Lion King", "Animation",
				19.95f, 87, "Roger Allers");
		    store.addMedia(dvd_1);
		DigitalVideoDisc dvd_2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				19.95f, 87, "George Lucas");
		    store.addMedia(dvd_2);
        CompactDisc cd_1 = new CompactDisc("Famous Friends", "Music",
                14.97f, 90, null, "Chris");
            store.addMedia(cd_1);
        CompactDisc cd_2 = new CompactDisc("Famous", "Music", 16.78f);
            store.addMedia(cd_2);

        new StoreScreen(store, cart);

	}
}

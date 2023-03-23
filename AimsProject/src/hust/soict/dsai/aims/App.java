package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store.Store;

public class App {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        Book book_1 = new Book("Twenty Thousand Leagues Under the Seas", "Adventure, Science fiction", 90f, null, 340);
            store.addMedia(book_1);
		DigitalVideoDisc dvd_1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
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

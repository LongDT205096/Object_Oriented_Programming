package hust.soict.dsai.test.cart.CartTest;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) throws LimitException{
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = 
            new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        cart.print();
    }    
}

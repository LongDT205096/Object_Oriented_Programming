package hust.soict.dsai.aims;

import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.dsai.aims.media.*;

public class Aims {
    public static void main(String[] args){
        Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
				"Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
				"George Lucas", 87, 19.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
				18.99f);
		store.addMedia(dvd3);
		
        CompactDisc cd1 = new CompactDisc("Famous Friends", "Music", 14.97f, 90, null, "Chris");
        store.addMedia(cd1);
        
        CompactDisc cd2 = new CompactDisc("Famous", "Music", 16.78f);
        store.addMedia(cd2);

        Cart Order = new Cart(); 
        Integer opt; Scanner Options;

        do{
            showMenu();
            Options = new Scanner(System.in);
            opt = Options.nextInt();

            if(opt == 1){ 
                //1. View store 
                Integer optStore;
                do{ 
                    store.print();
                    storeMenu();
                    optStore = Options.nextInt();
                    switch(optStore){
                        case 1: { 
                            //1. See a media’s details
                            System.out.println("Enter name of item: ");
                            Options.nextLine();
                            String infomation = Options.nextLine();
                            
                            Media Item = store.getMedia(infomation);
                            if(Item != null){
                                System.out.println("Detail of media: " + Item);
                                mediaDetailsMenu();
                                Integer optMedia;
        
                                do{
                                    optMedia = Options.nextInt();
                                    if(optMedia == 1) {
                                        Order.addMedia(Item);
                                        break;
                                    }
                                    else if(optMedia == 2) System.out.println(((Playable) Item).play());
                                } while(optMedia != 0);
                            } else System.out.println("Item not found\n");
                        } break;
                        
                        case 2:{ 
                            //2. Add a media to cart
                            System.out.println("Enter name of item: ");
                            Options.nextLine();
                            String infomation = Options.nextLine();
    
                            Media Item = store.getMedia(infomation);  
                            if(Item != null) Order.addMedia(Item);
                            else System.out.println("Item not found");
    
                            System.out.println("Number of items: " + Order.numberOfItem); 
                        } break;
                        
                        case 3:{ 
                            // 3. Play a media
                            System.out.println("Enter name of item: ");
                            Options.nextLine();
                            String infomation = Options.nextLine();
    
                            Media Item = store.getMedia(infomation);
                            if(Item != null) System.out.println(((Playable) Item).play());
                            else System.out.println("Item not found");
                            
                        } break;

                        case 4: {
                            //See current cart
                            Order.print();
                            System.out.print("\n");
                        } break;
                    }
                } while (optStore != 0);
                
            } else if(opt == 2){
                System.out.println("You want to add or remove?");
                Options.nextLine();
                String choice = Options.nextLine();
                
                switch(choice){
                    case "add": case "Add": {
                        System.out.println("Enter name of item: ");
                        String title = Options.nextLine();
                        Media Item = store.getMedia(title);
                        if(Item != null) Order.addMedia(Item);
                        else System.out.println("Item not found");
                    } break;

                    case "remove": case "Remove": {
                        System.out.println("Enter name of item: ");
                        String title = Options.nextLine();
                        Media Item = Order.getMedia(title);

                        Order.removeMedia(Item);
                    } break;

                    default: System.out.println("Wrong choice"); break;
                }
            } else if(opt == 3){
                Order.print();
                Integer optCart;

                do{
                    cartMenu();
                    optCart = Options.nextInt();

                    switch(optCart){
                        case 1: {
                            System.out.println("Enter type of sorting you want: ");
                            Options.nextLine();
                            String choice = Options.nextLine();

                            switch(choice){
                                case "id": case "ID": case "Id": {
                                    System.out.println("Enter Id of item: ");
                                    Options.nextLine();
                                    Integer Id = Options.nextInt();

                                    Media Item = Order.getMedia(Id);
                                    System.out.println("Detail of item:");
                                    System.out.println(Item);

                                } break;
                                case "title" : case "Title": {
                                    System.out.println("Enter title of item: ");
                                    Options.nextLine();
                                    String title = Options.nextLine();

                                    Media Item = Order.getMedia(title);
                                    System.out.println("Detail of item:");
                                    System.out.println(Item);

                                } break;
                            }
                        } break;

                        case 2: {
                            System.out.println("Sorting by cost or title?");
                            Options.nextLine();
                            String choice = Options.nextLine();

                            switch(choice){
                                case "cost": case "Cost": {
                                    Collections.sort(Order.getItemOrdered(), Media.COMPARE_BY_COST_TITLE);
                                    Order.print();
                                } break;
                                case "title": case "Title": {
                                    Collections.sort(Order.getItemOrdered(), Media.COMPARE_BY_TITLE_COST);
                                    Order.print();
                                } break;
                            }
                        } break;

                        case 3: {
                            System.out.println("Enter the name of media: ");
                            Options.nextLine();
                            String infomation = Options.nextLine();
                            Media Item = Order.getMedia(infomation);

                            Order.removeMedia(Item);
                        } break;

                        case 4: {
                            System.out.println("Enter the name of media: ");
                            Options.nextLine();
                            String infomation = Options.nextLine();
                            Media Item = Order.getMedia(infomation);

                            if(infomation != null) System.out.println(((Playable) Item).play());
                            else System.out.println("Item not found");
                        } break;
                        
                        case 5: {
                            System.out.println("Order success");
                            Order.getItemOrdered().clear();
                        }
                    }
                } while (optCart != 0);
            }
            System.out.print("\n");
        } while(opt != 0);

        Options.close();
        System.out.println("Exit");
        System.exit(0);
    }

    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu(){
        System.out.println("\nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu(){
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
		System.out.println("\nOptions: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
    }    
}
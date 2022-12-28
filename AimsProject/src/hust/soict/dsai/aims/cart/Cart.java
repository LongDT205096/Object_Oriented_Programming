package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    public int numberOfItem = 0;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public ArrayList<Media> getItemOrdered(){
        return itemsOrdered;
    }

    public void addMedia(Media media){
        if(itemsOrdered.contains(media)){
            System.out.println("This media has already been added.");
        } else{
            itemsOrdered.add(media);
            numberOfItem++;
            System.out.println("Adding successful\n");
        }
    }

    public void removeMedia(Media media){
        if(itemsOrdered.contains(media)){
            System.out.println("Remove the media " + media.getTitle());
            itemsOrdered.remove(media);
            numberOfItem--;
            System.out.println("Removing successfull");
        } else{
            System.out.println("This media is not in the list");
        }
    }

    public float totalCost(){
        float sum=0;
        for(Media x: itemsOrdered){
            sum += x.getCost();
        }
        return sum;
    }
    
    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(Media list : itemsOrdered){
            if(list == null) break;
            System.out.println(list);    
        }
        System.out.printf("Total cost: %.3f\n", this.totalCost());
        System.out.println("***************************************************");
    }

    public Media getMedia(String title){
        for(Media media : itemsOrdered){
            if (media.getTitle().equals(title)) {
				return media;
			}
        }
        return null;
    }

    public Media getMedia(Integer id){
        for(Media media : itemsOrdered){
            if (media.getId() == id) {
				return media;
			}
        }
        return null;
    }
}

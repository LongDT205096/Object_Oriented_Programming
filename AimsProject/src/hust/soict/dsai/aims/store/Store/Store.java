package hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    public void addMedia(Media media){
        if(itemsInStore.contains(media)){
            System.out.println("This media has already been added.");
        } else{
            itemsInStore.add(media);
        }
    }

    public void removeMedia(Media media){
        if(itemsInStore.contains(media)){
            System.out.println("Remove the media " + media.getTitle());
        } else{
            System.out.println("This media is not in the list");
        }
    }

    public Media getMedia(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}

    public void print(){
		System.out.println("***********************STORE***********************");
		System.out.println("Store Items:");
		int index = 0;
		for (Media d : itemsInStore) {
			if (d != null) {
				index++;
				System.out.println(index + ". " + d);
			}
		}
		System.out.println("***************************************************");
	}
}

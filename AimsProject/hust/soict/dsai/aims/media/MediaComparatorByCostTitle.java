package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{
    public int compare(Media media_1, Media media_2){
        float costDiff = media_1.getCost() - media_2.getCost();
        if(costDiff > 0) return 1;
        else if(costDiff < 0) return -1;
        else return media_1.getTitle().compareTo(media_2.getTitle()); 
    }
}

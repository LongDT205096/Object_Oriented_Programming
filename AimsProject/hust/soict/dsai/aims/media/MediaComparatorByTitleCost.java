package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
    public int compare(Media media_1, Media media_2){
        int titleDiff = media_1.getTitle().compareTo(media_2.getTitle());
        if(titleDiff != 0) return titleDiff;
        
        float costDiff = media_1.getCost() - media_2.getCost();
        if(costDiff > 0) return 1;
        else if(costDiff < 0) return -1;
        return 0;
    }
}

package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media {
    private int id;
    String title;
    private String category;
    private float cost;
    public static int nbMedia = 0;

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }
   
    public Media(String title) {
		this.title = title;
		nbMedia++;
		this.id = nbMedia;
	}

	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia++;
		this.id = nbMedia;
	}

    public boolean isMatch(String title) {
        return true;
    }	

    public boolean equals(Object o){
        try{
            return ((Media) o).getTitle() == this.title;
        } catch(Exception e){
            return false;
        }
    }

    public String toString(){
        return "Media" + " - " + this.title + " - " + this.category + ": " + this.cost + " $";
    }
}

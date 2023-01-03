package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media {
    private int id;
    private int length;
    private String title;
    private String category;
    private float cost;

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
    public int getLength(){
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }
   
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media(int id, String title) {
        this.id = id; 
		this.title = title;
	}

    public Media(int id, String title, int length){
        this.id = id;
        this.title = title;
        this.length = length; 
    }

    public Media(int id, String title, String category, float cost, int length) {
        this.id = id;
        this.length = length;
        this.title = title;
        this.category = category;
        this.cost = cost;
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

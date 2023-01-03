package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    public static int nbDigitalVideoDiscs = 0;
    
    public DigitalVideoDisc(String title){
        super(++nbDigitalVideoDiscs, title);
    }

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(++nbDigitalVideoDiscs, title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost);
    }

    //display
    public String play() {
        return "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
    }

    public String toString(){
        return "DVD " + this.getId() + " - " + this.getTitle() + " - " 
            + this.getCategory() + " - " + this.getDirector() + " - " 
            + this.getLength() + ": " + this.getCost() +"$";
    }
}

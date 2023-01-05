package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

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
    public String play() throws PlayerException {
        if (this.getLength() > 0) {
			return "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
        
    }

    public String toString(){
        return "DVD_" + this.getId() + " - " + this.getTitle() + " - " 
            + this.getCategory() + " - " + this.getDirector() + " - " 
            + this.getLength() + ": " + this.getCost() +"$";
    }
}

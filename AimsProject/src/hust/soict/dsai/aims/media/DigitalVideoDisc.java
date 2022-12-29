package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;

    public static int nbDigitalVideoDiscs = 0;

    public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}

    public DigitalVideoDisc(String title){
        super(title);
        DigitalVideoDisc.nbDigitalVideoDiscs++;
    } 
    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        ++DigitalVideoDisc.nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, cost);
        this.director = director;
        ++DigitalVideoDisc.nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
        ++DigitalVideoDisc.nbDigitalVideoDiscs;
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

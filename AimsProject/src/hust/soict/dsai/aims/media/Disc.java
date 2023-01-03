package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private int length;
    private String director;
    public static int nbDisc = 0;
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public Disc(int id, String title){
        super(++nbDisc, title);
    }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(++nbDisc, title, category, cost);
    }

    public Disc(int id, String title, String category, float cost) {
        super(++nbDisc, title, category, cost);
	}
}

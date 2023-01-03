package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private int length;
    private String director;
    
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }

    public Disc(int id, String title){
        super(id, title);
    }

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
	}
}

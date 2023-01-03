package hust.soict.dsai.aims.media;

public class Disc extends Media{
    private String director;
    
    public String getDirector() {
        return director;
    }

    public Disc(int id, String title){
        super(id, title);
    }

    public Disc(int id, String title, String category, float cost, int length, String director){
        super(id, title, category, cost, length);
        this.director = director;
    }

    public Disc(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }
}

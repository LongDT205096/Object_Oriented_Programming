package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    
    public Track(String title) {
		this.title = title;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
    
    public boolean equals(Object o){
        try{
            return this.title.equals(((Track) o).getTitle()) 
                && this.length == ((Track) o).getLength();
        } catch (Exception e){
            return false;
        }
    }
    
//display
    public String play() {
        return "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
    }
}

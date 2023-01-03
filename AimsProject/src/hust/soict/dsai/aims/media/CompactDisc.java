package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
	private ArrayList<Track> tracks = new 
			ArrayList<Track>();
    public static int nbCD = 0;
    
    public String getArtist() {
        return artist;
    }
            
    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public CompactDisc(String title, String category, float cost) {
		super(++nbCD, title, category, cost);
	}
    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
		super(++nbCD, title, category, cost, length, director);
		this.artist = artist;
	}
	
    public void addTrack(Track track){
        if (tracks.contains(track)) {
			System.out.println("This track has already been in the track list");
		} else{
            System.out.println("Added the track");
		    tracks.add(track);
        }
    }
    public void removeTrack(Track track){
        if (tracks.contains(track)) {
			System.out.println("Remove track " + track.getTitle());
            tracks.remove(track);
		} else{
            System.out.println("Track is not contained");
        }
    }

//display
    public String play() {
        return "Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength();
    }

    public String toString() {
		return "CD" + this.getId() + " - " + this.getTitle() + " - " + this.artist + " - " + this.getCategory()
				+ " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() + "$";
	}
}

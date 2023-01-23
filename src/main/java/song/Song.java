package song;

public class Song {
    
    private String newSongArtist;
    private String newSongTitle;
    private String newSongGenre;

    public Song(String newSongArtist, String newSongTitle, String newSongGenre) {
        this.newSongArtist = newSongArtist;
        this.newSongTitle = newSongTitle;
        this.newSongGenre = newSongGenre;
    }

    public String getNewSongArtist() {
        return newSongArtist;
    }

    public void setNewSongArtist(String newSongArtist) {
        this.newSongArtist = newSongArtist;
    }

    public String getNewSongTitle() {
        return newSongTitle;
    }

    public void setNewSongTitle(String newSongTitle) {
        this.newSongTitle = newSongTitle;
    }

    public String getNewSongGenre() {
        return newSongGenre;
    }

    public void setNewSongGenre(String newSongGenre) {
        this.newSongGenre = newSongGenre;
    }
}

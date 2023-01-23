package song;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateController {
   
    @FXML
    private TextField artist;

    @FXML
    private TextField genre;

    @FXML
    private TextField title;

    private Song song;
    private Controller parent;

    @FXML
    public void update(ActionEvent event) {
        song.setNewSongArtist(artist.getText());
        song.setNewSongGenre(genre.getText());
        song.setNewSongTitle(title.getText());
        parent.onSongUpdate();
    }

    public void setSongData(Song song) {
        this.song = song;
        artist.setText(song.getNewSongArtist());
        genre.setText(song.getNewSongGenre());
        title.setText(song.getNewSongTitle());
    }

    public void setParent(Controller parent) {
        this.parent = parent;
    }
}

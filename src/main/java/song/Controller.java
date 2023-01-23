package song;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private TextField newSongArtist;

    @FXML
    private TextField newSongGenre;

    @FXML
    private Button newSongSubmit;

    @FXML
    private TextField newSongTitle;

    @FXML
    private TableColumn<Song, String> songArtist;

    @FXML
    private Button songDelete;

    @FXML
    private TableColumn<Song, String> songGenre;

    @FXML
    private TableColumn<Song, String> songTitle;

    @FXML
    private Button songUpdate;

    @FXML
    private TableView<Song> tableView;

    private Stage popUpWindow;

    @FXML
    public void deleteSong(ActionEvent event) {
        tableView.getItems().remove(tableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void updateSong(ActionEvent event) throws IOException {
        this.popUpWindow = new Stage();

        popUpWindow.initModality(Modality.APPLICATION_MODAL);
        popUpWindow.setTitle("Update song");
        FXMLLoader loader = loadFXML("update");
        Scene scene = new Scene(loader.load(), 530, 419);
        popUpWindow.setScene(scene);

        UpdateController updateController = loader.getController();
        updateController.setParent(this);
        updateController.setSongData(tableView.getSelectionModel().getSelectedItem());

        popUpWindow.showAndWait();
    }

    @FXML
    public void addSong(ActionEvent event) {
        String newSongArtist = this.newSongArtist.getText();
        String newSongTitle = this.newSongTitle.getText();
        String newSongGenre = this.newSongGenre.getText();

        if(!newSongArtist.isEmpty() && !newSongTitle.isEmpty() && !newSongGenre.isEmpty()) {
            list.add(new Song(newSongArtist, newSongTitle, newSongGenre));
            this.newSongArtist.setText("");
            this.newSongTitle.setText("");
            this.newSongGenre.setText("");
        }
    }

    private FXMLLoader loadFXML(String fxml) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    ObservableList<Song> list = FXCollections.observableArrayList(
        new Song("Tiesto", "Elements of Life", "Trance"),
        new Song("Tiesto", "Traffic", "Trance")
    );
   
    public void onSongUpdate() {
        tableView.refresh();
        popUpWindow.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle  resourceBundle) {
        songArtist.setCellValueFactory(new PropertyValueFactory<Song, String>("newSongArtist"));
        songTitle.setCellValueFactory(new PropertyValueFactory<Song, String>("newSongTitle"));
        songGenre.setCellValueFactory(new PropertyValueFactory<Song, String>("newSongGenre"));

        tableView.setItems(list);        
    }
}

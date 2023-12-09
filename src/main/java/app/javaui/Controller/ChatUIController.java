package app.javaui.Controller;

import app.javaui.Message;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ChatUIController implements Initializable {
    @FXML
    private TextField typeBox;

    @FXML
    private VBox vBoxMess;

    @FXML
    private ScrollPane container;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vBoxMess.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                container.setVvalue((Double) t1);
            }
        });
    }


    public void getText() {
        if (typeBox.getText().isBlank()) {
            return;
        }
        Message newMessage = new Message();
        newMessage.setMessage(typeBox.getText());
        newMessage.setSide("left");

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_RIGHT);

        Label label = new Label(newMessage.getMessage());
        label.getStylesheets().add(getClass().getResource("/app/javaui/css/chat.css").toExternalForm());
        label.getStyleClass().add("chat_bubble");
        label.setWrapText(true);

        hbox.getChildren().add(label);
        vBoxMess.setSpacing(10);
        vBoxMess.getChildren().add(hbox);

        typeBox.clear();
    }

}
package sample;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.control.*;
import javafx.fxml.FXML;





public class LoginController {
    public LoginController(TextField tfUser, PasswordField tfPass, Button bLogin, FontAwesomeIconView faClose) {
        this.tfUser = tfUser;
        this.tfPass = tfPass;
        this.bLogin = bLogin;
        this.faClose = faClose;
    }


    @FXML
    private TextField tfUser;
    @FXML
    private PasswordField tfPass;
    @FXML
    private Button bLogin;
    @FXML
    private FontAwesomeIconView faClose;

    public TextField getTfUser() {
        return tfUser;
    }

    public void setTfUser(TextField tfUser) {
        this.tfUser = tfUser;
    }

    public PasswordField getTfPass() {
        return tfPass;
    }

    public void setTfPass(PasswordField tfPass) {
        this.tfPass = tfPass;
    }

    public Button getbLogin() {
        return bLogin;
    }

    public void setbLogin(Button bLogin) {
        this.bLogin = bLogin;
    }

    public FontAwesomeIconView getFaClose() {
        return faClose;
    }

    public void setFaClose(FontAwesomeIconView faClose) {
        this.faClose = faClose;
    }

}

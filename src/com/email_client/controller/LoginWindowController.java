package com.email_client.controller;

import com.email_client.EmailManager;
import com.email_client.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends BaseController {

    @FXML
    private TextField emailAddressField;

    @FXML
    private TextField passwordField;

    @FXML
    private Label errorLabel;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction() {
        // Todo -> Add login functionality
        viewFactory.showMainWindow();
        // Close login stage
        Stage stage = (Stage) this.errorLabel.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

}

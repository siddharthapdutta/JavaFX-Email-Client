package com.email_client.view;

import com.email_client.EmailManager;
import com.email_client.controller.BaseController;
import com.email_client.controller.LoginWindowController;
import com.email_client.controller.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewFactory {

    private EmailManager emailManager;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    private void initializeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent;
        try {
            parent = fxmlLoader.load();
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }

    public void showLoginWindow() {
        BaseController controller = new LoginWindowController(this.emailManager, this, "LoginWindow.fxml");
        this.initializeStage(controller);
    }

    public void showMainWindow() {
        BaseController controller = new MainWindowController(this.emailManager, this, "MainWindow.fxml");
        this.initializeStage(controller);
    }
}

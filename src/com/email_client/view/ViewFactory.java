package com.email_client.view;

import com.email_client.EmailManager;
import com.email_client.controller.BaseController;
import com.email_client.controller.LoginWindowController;
import com.email_client.controller.MainWindowController;
import com.email_client.controller.OptionsWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;

    private ArrayList<Stage> activeStages;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        this.activeStages = new ArrayList<>();
    }

    // View options handling
    private ColorTheme colorTheme = ColorTheme.DEFAULT;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    private void initializeStage(BaseController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);

        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        activeStages.add(stage);
    }

    public void closeStage(Stage stage) {
        stage.close();
        activeStages.remove(stage);
    }

    public void showLoginWindow() {
        BaseController controller = new LoginWindowController(this.emailManager, this, "LoginWindow.fxml");
        this.initializeStage(controller);
    }

    public void showMainWindow() {
        BaseController controller = new MainWindowController(this.emailManager, this, "MainWindow.fxml");
        this.initializeStage(controller);
    }

    public void showOptionsWindow() {
        BaseController controller = new OptionsWindowController(this.emailManager, this, "OptionsWindow.fxml");
        this.initializeStage(controller);
    }

    public void updateStyles() {
        for (Stage stage : this.activeStages) {
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }
}

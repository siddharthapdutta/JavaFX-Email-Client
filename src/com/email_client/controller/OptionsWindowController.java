package com.email_client.controller;

import com.email_client.EmailManager;
import com.email_client.view.ColorTheme;
import com.email_client.view.FontSize;
import com.email_client.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    @FXML
    private Slider fontSizePicker;

    @FXML
    private ChoiceBox<ColorTheme> themePicker;

    public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void applyButtonAction() {
        this.viewFactory.setColorTheme(themePicker.getValue());
        this.viewFactory.setFontSize(FontSize.values()[(int)(fontSizePicker.getValue())]);
        this.viewFactory.updateStyles();
    }

    @FXML
    void cancelButtonAction() {
        Stage stage = (Stage) fontSizePicker.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.setUpColorThemePicker();
        this.setUpFontSizePicker();
    }

    private void setUpColorThemePicker() {
        themePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        themePicker.setValue(this.viewFactory.getColorTheme());
    }

    private void setUpFontSizePicker() {
        fontSizePicker.setMin(0);
        fontSizePicker.setMax(FontSize.values().length - 1);
        fontSizePicker.setValue(this.viewFactory.getFontSize().ordinal());
        fontSizePicker.setMajorTickUnit(1);
        fontSizePicker.setMinorTickCount(0);
        fontSizePicker.setBlockIncrement(1);
        fontSizePicker.setSnapToTicks(true);
        fontSizePicker.setShowTickMarks(true);
        fontSizePicker.setShowTickLabels(true);
        fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });
        fontSizePicker.valueProperty().addListener(((observableValue, oldVal, newVal) -> {
            fontSizePicker.setValue(newVal.intValue());
        }));

    }
}

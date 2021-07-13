module JavaFXEmailClient {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;

    opens com.email_client;
    opens com.email_client.view;
    opens com.email_client.controller;
}
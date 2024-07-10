module project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires jdk.compiler;
    requires com.fasterxml.jackson.databind;
    requires gson;
    exports model.card;
    exports view;
    opens view to javafx.fxml;
    exports controller;
    opens controller to javafx.fxml;
    exports model;
//    opens model to javafx.fxml;
    exports Enums;
    opens model.card to com.fasterxml.jackson.databind;
    opens model to com.fasterxml.jackson.databind;
    exports Client;
    opens Client to com.fasterxml.jackson.databind;
    exports server;
    opens server to com.fasterxml.jackson.databind;

}
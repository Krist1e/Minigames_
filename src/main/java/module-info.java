module com.minigames {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    // requires eu.hansolo.tilesfx;
    requires java.desktop;
    requires javafx.media;
    requires org.junit.jupiter.api;
    requires junit;
    requires mockito.all;


    opens com.minigames to javafx.base, javafx.fxml, javafx.graphics;
    exports com.minigames;
    exports Tests;
}
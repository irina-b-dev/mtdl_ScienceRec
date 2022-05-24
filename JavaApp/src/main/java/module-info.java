module com.example.sciencerec {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.jfxtras.styles.jmetro;
    requires poi;
    requires poi.ooxml;
    opens com.example.sciencerec to javafx.fxml;
    exports com.example.sciencerec;
}
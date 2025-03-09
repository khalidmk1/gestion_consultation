module com.consultation.gestion_consultation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens com.consultation.gestion_consultation.controllers to javafx.fxml;
    opens com.consultation.gestion_consultation.entities to javafx.base;
    exports com.consultation.gestion_consultation;
}
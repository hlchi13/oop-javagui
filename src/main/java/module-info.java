module app.javaui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens app.javaui to javafx.fxml;
    exports app.javaui;
    exports app.javaui.Controller;
    opens app.javaui.Controller to javafx.fxml;
}
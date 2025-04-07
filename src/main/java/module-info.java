module com.example.elaboratocsvdef {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.elaboratocsvdef to javafx.fxml;
    exports com.example.elaboratocsvdef;
}
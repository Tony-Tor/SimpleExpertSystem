module org.astu.students.simpleexpertsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.astu.students.simpleexpertsystem to javafx.fxml;
    exports org.astu.students.simpleexpertsystem;
}
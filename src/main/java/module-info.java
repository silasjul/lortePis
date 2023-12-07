module com.what.maventest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.what.maventest to javafx.fxml;
    exports com.what.maventest;
}
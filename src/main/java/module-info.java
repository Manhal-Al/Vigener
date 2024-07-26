module mypackage1.vigener {
    requires javafx.controls;
    requires javafx.fxml;


    opens mypackage1.vigener to javafx.fxml;
    exports mypackage1.vigener;
}
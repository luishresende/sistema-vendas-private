package codemarket.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TableView;

public class SalesViewController implements Initializable {

    @FXML
    private LineChart<?, ?> lineChartGeralSales;

    @FXML
    private NumberAxis bcgsNumbers;

    @FXML
    private CategoryAxis lcusCategorys;

    @FXML
    private BarChart<?, ?> barChartUserSales;

    @FXML
    private BarChart<?, ?> barChartGeralSales;

    @FXML
    private NumberAxis lcgsNumbers;

    @FXML
    private CategoryAxis bcgsCategorys;

    @FXML
    private TableView<?> tableViewGeralSales;

    @FXML
    private CategoryAxis lcgsCategorys;

    @FXML
    private LineChart<?, ?> lineChartUserSales;

    @FXML
    private TableView<?> tableViewUserSales;

    @FXML
    private CategoryAxis bcusCategorys;

    @FXML
    private NumberAxis bcusNumbers;

    @FXML
    private NumberAxis lcusNumbers;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

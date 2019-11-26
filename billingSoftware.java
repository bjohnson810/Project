import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicBoolean;

public class billingSoftware extends Application{
    private BorderPane bPane = new BorderPane();
    private GridPane gPane1 = new GridPane();
    private GridPane gPane2 = new GridPane();
    private FlowPane fPane = new FlowPane();
    private VBox vBox1 = new VBox();
    private VBox vBox2 = new VBox();
    private VBox vBox3 = new VBox();

    private ObservableList<Item> data;

    public void start(Stage myStage) throws Exception{
        myStage.setTitle("Burgundy's Project");  //title of window


        TableView<Item> itemTable;  //table view that stores Grocery objects
        itemTable = new TableView<>();

        Alert infoAlert = new Alert(Alert.AlertType.INFORMATION);
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        Scene scene1, scene2, scene3;  //create scenes... will be for add, update, and remove scenes
        scene1 = new Scene(new Group());  //this is the main scene/what shows when window opens aka add
        myStage.sizeToScene();

        /*-------------these buttons will be along the top------------*/


        Button button1 = new Button("Add");
        Button button2 = new Button("Update");
        Button button3 = new Button("Remove");
        fPane.getChildren().addAll(button1, button2, button3);


        /*--------------------next section displays Grocery table on right side--------------------*/


        data = FXCollections.observableArrayList();
        myStage.setWidth(900);
        myStage.setHeight(900);
        final Label label1 = new Label("Items");
        label1.setFont(new Font("Arial", 20));

        //Column1
        TableColumn itemCodeColumn = new TableColumn("Item Code");
        itemCodeColumn.setMinWidth(10);
        itemCodeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemCode"));

        //Second Column
        TableColumn itemNameColumn = new TableColumn("Item Name");
        itemNameColumn.setMinWidth(50);
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemName"));

        //Third Column
        TableColumn itemTypeColumn = new TableColumn("Item Type");
        itemTypeColumn.setMinWidth(50);
        itemTypeColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("itemType"));

        //Fourth Column
        TableColumn brandColumn = new TableColumn("Brand");
        brandColumn.setMinWidth(70);
        brandColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("brand"));

        //Fifth Column
        TableColumn quantityColumn = new TableColumn("Quantity");
        quantityColumn.setMinWidth(10);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));

        //Sixth Column
        TableColumn priceColumn = new TableColumn("Price");
        priceColumn.setMinWidth(50);
        priceColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("price"));

        //Seventh Column
        TableColumn discountColumn = new TableColumn("Discount");
        discountColumn.setMinWidth(50);
        discountColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("discount"));

        //Eighth Column
        TableColumn taxColumn = new TableColumn("Tax");
        taxColumn.setMinWidth(10);
        taxColumn.setCellValueFactory(new PropertyValueFactory<Item, Double>("tax"));


        itemTable.setEditable(true);
        itemTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        itemTable.setItems(data);
        itemTable.getColumns().addAll(itemCodeColumn, itemNameColumn, itemTypeColumn, brandColumn, quantityColumn, priceColumn, discountColumn, taxColumn);
        vBox1.getChildren().addAll(label1, itemTable);


        /*-----------------------this is the left pane and adding items to the table---------------------*/


        Label icLabel = new Label("Item Code");
        Label inLabel = new Label("Item Name");
        Label itLabel = new Label("Item Type");
        Label bLabel = new Label("Brand");
        Label qLabel = new Label("Quantity");
        Label pLabel = new Label("Price");
        Label dLabel = new Label("Discount");
        Label tLabel = new Label("Tax");



        TextField icField = new TextField();
        TextField inField = new TextField();
        TextField itField = new TextField();
        TextField bField = new TextField();
        TextField qField = new TextField();
        TextField pField = new TextField();
        TextField dField = new TextField();
        TextField tField = new TextField();
        Button addButton = new Button("Add New Item");

        gPane1.add(icLabel, 0,0);
        gPane1.add(icField,1,0);
        gPane1.add(inLabel,0,1);
        gPane1.add(inField,1,1);
        gPane1.add(itLabel,0,2);
        gPane1.add(itField,1,2);
        gPane1.add(bLabel,0,3);
        gPane1.add(bField,1,3);
        gPane1.add(qLabel,0,4);
        gPane1.add(qField,1,4);
        gPane1.add(pLabel,0,5);
        gPane1.add(pField,1,5);
        gPane1.add(dLabel,0,6);
        gPane1.add(dField,1,6);
        gPane1.add(tLabel,0,7);
        gPane1.add(tField,1,7);

        gPane1.setPadding(new Insets(10,10,10,10));
        gPane1.setHgap(10);
        gPane1.setVgap(10);
        vBox2.setSpacing(5);
        vBox2.setPadding(new Insets(5,5,5,5));
        vBox2.getChildren().addAll(gPane1, addButton);
        vBox2.setVisible(false);
        bPane.setPadding(new Insets(10,10,10,10));
        bPane.setLeft(vBox2);
        bPane.setRight(vBox1);
        bPane.setTop(fPane);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                vBox2.setVisible(true);
            }
        };
        button1.setOnAction(event1);

        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.add(new Item(icField.getText(),  inField.getText(), itField.getText(), bField.getText(), Integer.parseInt(qField.getText()), Double.parseDouble(pField.getText()), Double.parseDouble(dField.getText()), Double.parseDouble(tField.getText())));
                icField.clear();
                inField.clear();
                itField.clear();
                bField.clear();
                qField.clear();
                pField.clear();
                dField.clear();
                tField.clear();
            }
        };
        addButton.setOnAction(event2);

        ((Group) scene1.getRoot()).getChildren().add(bPane);
        myStage.setScene(scene1);
        myStage.show();


        /*--------------------------------start scene 2, update quantity and/or price------------------------------------*/


        Label updateLabel = new Label("Enter the code of the item to update its price and/or quantity.");
        updateLabel.setFont(new Font("Arial", 14));
        Label icUpdateLabel = new Label("Item Code");
        Label inUpdateLabel = new Label("Item Name");
        Label itUpdateLabel = new Label("Item Type");
        Label ibUpdateLabel = new Label("Item Brand");
        Label pUpdateLabel = new Label("Price");
        Label qUpdateLabel = new Label("Quantity");
        Label idUpdateLabel = new Label("Item Discount");
        Label tUpdateLabel = new Label("Item Tax");

        TextField icUpdateField = new TextField();
        TextField inUpdateField = new TextField();
        TextField itUpdateField = new TextField();
        TextField ibUpdateField = new TextField();
        TextField pUpdateField = new TextField();
        TextField qUpdateField = new TextField();
        TextField idUpdateField = new TextField();
        TextField tUpdateField = new TextField();


        Button updateButton = new Button("Update");
        gPane2.add(icUpdateLabel,0,0);
        gPane2.add(icUpdateField,1,0);
        gPane2.add(inUpdateLabel,0,1);
        gPane2.add(inUpdateField,1,1);
        gPane2.add(itUpdateLabel,0,2);
        gPane2.add(itUpdateField,1,2);
        gPane2.add(ibUpdateLabel,0,3);
        gPane2.add(ibUpdateField,1,3);
        gPane2.add(pUpdateLabel,0,4);
        gPane2.add(pUpdateField,1,4);
        gPane2.add(qUpdateLabel,0,5);
        gPane2.add(qUpdateField,1,5);
        gPane2.add(idUpdateLabel,0,6);
        gPane2.add(idUpdateField,1,6);
        gPane2.add(tUpdateLabel,0,7);
        gPane2.add(tUpdateField,1,7);


        Label uLabel = new Label();
        gPane2.setPadding(new Insets(10,10,10,10));
        gPane2.setHgap(10);
        gPane2.setVgap(10);
        vBox3.getChildren().addAll(updateLabel, gPane2, updateButton, uLabel);
        vBox3.setSpacing(10);
        vBox3.setPadding(new Insets(10,10,10,10));

        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String upItemCode = icUpdateField.getText();
                boolean flag = false;

                for(int i = 0; i<itemTable.getItems().size(); i++){
                    if((itemTable.getItems().get(i).getItemCode()).equals(upItemCode)){
                        Item p = new Item(icUpdateField.getText(), inUpdateField.getText(), itUpdateField.getText(),
                                ibUpdateField.getText(), Integer.parseInt(qUpdateField.getText()), Double.parseDouble(pUpdateField.getText()),
                                Double.parseDouble(idUpdateField.getText()),Double.parseDouble(tUpdateField.getText()));
                        itemTable.getItems().set(i, p);


                        flag = true;
                    }
                }

                if(flag){
                    infoAlert.setTitle("Success");
                    infoAlert.setHeaderText(null);
                    infoAlert.setContentText("Update Successful");
                    infoAlert.showAndWait();
                }

                else{
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Could not find item code");
                    errorAlert.showAndWait();
                }

                icUpdateField.clear();
                pUpdateField.clear();
                qUpdateField.clear();
                myStage.setScene(scene1);  //go back to original scene after updating
            }
        };
        updateButton.setOnAction(event3);

        scene2 = new Scene(vBox3,400,400);

        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                myStage.setScene(scene2);
            }
        };
        button2.setOnAction(event4);



        /*-----------------------------scene 3, remove item --------------------------------------*/


        VBox vBox4 = new VBox();
        Label removeLabel = new Label("Enter the item code to remove");
        TextField removeField = new TextField();
        Button deleteButton = new Button("Delete");
        vBox4.getChildren().addAll(removeLabel, removeField, deleteButton );
        vBox4.setPadding(new Insets(10,10,10,10));
        vBox4.setSpacing(10);
        scene3 = new Scene(vBox4, 200, 200);

        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String remIC = removeField.getText();
                boolean rflag = false;

                for(int i = 0; i<itemTable.getItems().size(); i++){
                    if((itemTable.getItems().get(i).getItemCode()).equals(remIC)){
                        itemTable.getItems().remove(i);
                        rflag = true;
                    }
                }

                if(rflag){
                    infoAlert.setTitle("Success");
                    infoAlert.setHeaderText(null);
                    infoAlert.setContentText("Deletion Successful");
                    infoAlert.showAndWait();
                }
                else{
                    errorAlert.setTitle("Error");
                    errorAlert.setHeaderText(null);
                    errorAlert.setContentText("Could not find item code");
                    errorAlert.showAndWait();
                }
                removeField.clear();
                myStage.setScene(scene1);
            }
        };
        deleteButton.setOnAction(event5);

        EventHandler<ActionEvent> event6 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                myStage.setScene(scene3);
            }
        };
        button3.setOnAction(event6);


    } //end of myStage

    public static void main(String[] args){
        launch(args);
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.mockobservedservice;

import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Screen;

/**
 *
 * @author LEVALLOIS
 */
public class TestPane extends Pane {

    Rectangle2D primaryScreenBounds;
    int gapBetweenText = 50;

    public TestPane() {
        this.primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double preferredWidth = primaryScreenBounds.getWidth() / 1.5;
        double preferredHeight = primaryScreenBounds.getHeight() / 1.5;

        BorderPane rootPanel = new BorderPane();
        BorderPane bottomPanel = new BorderPane();
        int row = 0;
        GridPane centerPanel = new GridPane();
        rootPanel.setPadding(new Insets(20));
        rootPanel.setPrefSize(preferredWidth, preferredHeight);

        Label warnings = new Label("This is where warnings go");
        warnings.setStyle("-fx-font-weight: bold");
        bottomPanel.setLeft(warnings);

        Label invitation = new Label("Hi this is a test panel");

        centerPanel.add(invitation, 1, row++);
        Region region = new Region();
        region.setMinHeight(gapBetweenText);
        region.setMaxWidth(10);
        centerPanel.add(region, 1, row++);

        Label invitation2 = new Label("Hi this is a second sentence");

        centerPanel.add(invitation2, 1, row++);
        region = new Region();
        region.setMinHeight(gapBetweenText);
        region.setMaxWidth(10);
        centerPanel.add(region, 1, row++);

        rootPanel.setCenter(centerPanel);
        rootPanel.setBottom(bottomPanel);

        this.getChildren().add(rootPanel);

    }

}

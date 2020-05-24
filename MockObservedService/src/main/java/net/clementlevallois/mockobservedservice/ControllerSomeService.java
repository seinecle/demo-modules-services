/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.mockobservedservice;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author LEVALLOIS
 */
public class ControllerSomeService {

    public ControllerSomeService() {
        
    }

    public ControllerSomeService(Stage stage) {
        Scene scene = stage.getScene();
        BorderPane root = (BorderPane) scene.getRoot();
        TestPane testPane = new TestPane();
        root.setCenter(testPane);
        scene.setRoot(root);
        stage.setScene(scene);
    }

}

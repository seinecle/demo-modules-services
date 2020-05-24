/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.monitor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.clementlevallois.monitorobserver.DiagnosticDataPoint;
import net.clementlevallois.monitorobserver.ServiceObserver;
import net.clementlevallois.monitorobserver.ServiceObserverFactory;

/**
 *
 * @author LEVALLOIS
 */
public class Controller extends Application {

    @Override
    public void start(Stage stage) throws InterruptedException {

        List<ServiceObserverFactory> observerFactories = ServiceLoader
                .load(ServiceObserverFactory.class).stream()
                .map(Provider::get)
                .collect(toList());
        List<ServiceObserver> observers = Stream.of("beta-1")
                .map(serviceName -> createObserver(observerFactories, serviceName))
                .flatMap(Optional::stream)
                .collect(toList());

        ServiceObserver serviceObserver = observers.get(0);
        for (int i = 0; i < 10; i++) {
            DiagnosticDataPoint dataPoint = serviceObserver.gatherDataFromService();
            System.out.println("module is alive? -> " + dataPoint.alive());
            Thread.sleep(1000);
        }


        // #4 load menu bar and status bar
        BorderPane borderPane = new BorderPane();

        Scene scene = new Scene(borderPane);

        //set icon that will appear on the usee desktop
//        InputStream resourceAsStream = ResourceLoader.getResourceAsStream("gephi.png");
//        stage.getIcons().add(new Image(resourceAsStream));
        stage.setTitle("Demo module app");
        stage.setScene(scene);

        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    private static Optional<ServiceObserver> createObserver(
            List<ServiceObserverFactory> observerFactories, String serviceName) {

        return observerFactories.stream()
                .flatMap(factory -> factory.createIfMatchingService(serviceName).stream())
                .findFirst();
    }

}

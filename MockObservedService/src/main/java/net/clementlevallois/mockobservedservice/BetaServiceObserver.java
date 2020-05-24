/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.mockobservedservice;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Random;
import net.clementlevallois.monitorobserver.DiagnosticDataPoint;
import net.clementlevallois.monitorobserver.ServiceObserver;

public class BetaServiceObserver implements ServiceObserver {

    private static final Random RANDOM = new Random();

    private final String serviceName;

    BetaServiceObserver(String serviceName) {
        this.serviceName = serviceName;
    }

    public static Optional<ServiceObserver> createIfBetaService(String service) {
        return Optional.of(service)
                // this check should do something more sensible
                .filter(s -> s.toLowerCase().contains("beta"))
                .map(BetaServiceObserver::new);
    }

    @Override
    public DiagnosticDataPoint gatherDataFromService() {
        // this check should actually contact the serviceName
        boolean alive = RANDOM.nextFloat() > 0.5f;
        return DiagnosticDataPoint.of(serviceName, ZonedDateTime.now(), alive);
    }

}

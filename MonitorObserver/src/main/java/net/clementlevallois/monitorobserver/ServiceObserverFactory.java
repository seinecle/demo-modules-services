/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.monitorobserver;

/**
 *
 * @author LEVALLOIS
 */
import java.util.Optional;

public interface ServiceObserverFactory {

	Optional<ServiceObserver> createIfMatchingService(String service);

}

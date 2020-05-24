/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.clementlevallois.mockobservedservice;


import java.util.Optional;
import net.clementlevallois.monitorobserver.ServiceObserver;
import net.clementlevallois.monitorobserver.ServiceObserverFactory;

public class BetaServiceObserverFactory implements ServiceObserverFactory {

	@Override
	public Optional<ServiceObserver> createIfMatchingService(String service) {
		return BetaServiceObserver.createIfBetaService(service);
	}

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import net.clementlevallois.monitorobserver.ServiceObserverFactory;

module net.clementlevallois.monitor {
    requires net.clementlevallois.monitorobserver;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;

    uses ServiceObserverFactory;
        
    exports net.clementlevallois.monitor;

}

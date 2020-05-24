module net.clementlevallois.mockobservedcervice {
    requires javafx.controls;
    requires javafx.graphics;
    requires net.clementlevallois.monitorobserver;
    
    provides net.clementlevallois.monitorobserver.ServiceObserverFactory
		with net.clementlevallois.mockobservedservice.BetaServiceObserverFactory;
}
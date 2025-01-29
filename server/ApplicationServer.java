package server;

import interfaces.ApplicationHandler;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Main class for the server
public class ApplicationServer {
    public static void main(String[] args) {
        // Get the port number from the command line arguments - or use the default
        int registryport = 20345;
        if (args.length > 0) {
           registryport = Integer.parseInt(args[0]);
        }
        System.out.println("RMIRegistry port = " + registryport);

        try {
            // Bind the ApplicationHandler to the registry
            String name = "ApplicationHandler";
            ApplicationHandler handler = new ApplicationHandlerImpl();

            // Export the handler object so that it can be accessed remotely
            ApplicationHandler stub = (ApplicationHandler) UnicastRemoteObject.exportObject(handler, 0);

            // Get the registry and bind the exported handler to the registry
            Registry registry = LocateRegistry.getRegistry(registryport);
            registry.rebind(name, stub);
            System.out.println("ApplicationHandler bound");
        } catch (Exception e) {
            System.err.println("ApplicationHandler exception:");
            e.printStackTrace();
        }
    } 
}

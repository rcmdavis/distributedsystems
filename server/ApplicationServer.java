package server;

import interfaces.ApplicationHandler;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ApplicationServer {
    public static void main(String[] args) {
        int registryport = 20345;

        if (args.length > 0)
           registryport = Integer.parseInt(args[0]);
        
        System.out.println("RMIRegistry port = " + registryport);

        try {
            String name = "ApplicationHandler";
            ApplicationHandler handler = new ApplicationHandlerImpl();
            ApplicationHandler stub =
                (ApplicationHandler) UnicastRemoteObject.exportObject(handler, 0);
            Registry registry = LocateRegistry.getRegistry(registryport);
            registry.rebind(name, stub);
            System.out.println("ApplicationHandler bound");
        } catch (Exception e) {
            System.err.println("ApplicationHandler exception:");
            e.printStackTrace();
        }
    } 
}

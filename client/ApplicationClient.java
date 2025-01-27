package client;

import interfaces.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ApplicationClient {
    public static void main(String args[]) {
        int registryport = 20345;

        if (args.length > 0)
        registryport = Integer.parseInt(args[0]);

        System.out.println("RMIRegistry port = " + registryport);

        // SecurityManager is deprecated so no longer used in this application
        // if (System.getSecurityManager() == null) {
        //    System.setSecurityManager(new SecurityManager());
        // }

        try {
            String name = "ApplicationHandler";
            Registry registry = LocateRegistry.getRegistry(registryport);
            ApplicationHandler handler = (ApplicationHandler) registry.lookup(name);
            System.out.println(handler.login("Ryan", "password"));
        } catch (Exception e) {
            System.err.println("ApplicationClient exception:");
            e.printStackTrace();
        }
    }    
}

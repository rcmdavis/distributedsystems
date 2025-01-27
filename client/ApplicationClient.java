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
            long id = handler.login("Ryan", "password");
            ApplicationForm form = handler.getApplicationForm(id);
            for (int i = 1; i <= form.numberOfQuestions(); i++) {
                System.out.println(form.getQuestion(i));
                System.out.print("Answer for question " + i + ": ");
                String answer = System.console().readLine();
                form.setAnswer(i, answer);
            }
            handler.submitApplicationForm(id, form);
        } catch (Exception e) {
            System.err.println("ApplicationClient exception:");
            e.printStackTrace();
        }
    }    
}

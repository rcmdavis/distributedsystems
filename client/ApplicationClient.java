package client;

import interfaces.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ApplicationClient {
    public static void main(String args[]) {
        // Set up registry port with argument, or default to 20345
        int registryport = 20345;
        if (args.length > 0) {
            registryport = Integer.parseInt(args[0]);
        }
        System.out.println("RMIRegistry port = " + registryport);

        try {
            // Get the registry at the provided port and look up the ApplicationHandler
            String name = "ApplicationHandler";
            Registry registry = LocateRegistry.getRegistry(registryport);
            ApplicationHandler handler = (ApplicationHandler) registry.lookup(name);


            System.out.print("Enter username: ");
            String username = System.console().readLine();
            System.out.print("Enter password: ");
            String password = System.console().readLine();

            // Login with the user-entered credentials
            long id = handler.login(username, password);

            System.out.println("ID: " + id);

            System.out.print("Press Enter To Continue: ");
            System.console().readLine();

            // // Code to manually enter ID
            // System.out.print("Enter ID To Continue: ");
            // id = Long.valueOf(System.console().readLine());

            // Get the application form using the session ID and fill it out
            ApplicationForm form = handler.getApplicationForm(id);
            for (int i = 1; i <= form.numberOfQuestions(); i++) {
                System.out.println(form.getQuestion(i));
                System.out.print("Answer for question " + i + ": ");
                String answer = System.console().readLine();
                form.setAnswer(i, answer);
            }

            // Submit the form
            handler.submitApplicationForm(id, form);
        } catch (Exception e) {
            // If we get an exception, just print it
            System.err.println("ApplicationClient exception:");
            e.printStackTrace();
        }
    }    
}

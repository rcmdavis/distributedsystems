package server;

import interfaces.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import exceptions.*;

public class ApplicationHandlerImpl implements ApplicationHandler {
    // hashmap to store session IDs and their respective timestamps
    private HashMap<Long, Long> ids = new HashMap<Long, Long>();

    // Implementation of login method - checking if the (hardcoded) username and password are correct
    @Override
    public long login(String username, String password) throws InvalidCredentialsException{
        // Check hardcoded username and password
        if (!username.equals("Ryan") || !password.equals("password")) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        Long id;
        do {    // Generate new session ID until a unique one is found
            id = Long.valueOf((long)(Math.random() * (999999L)));
        } while (ids.containsKey(id));
        
        Long currentTime = System.currentTimeMillis();

        ids.put(id, currentTime);
        
        return id;
    }


    // Implementation of getApplicationForm method - returning an application form
    @Override
    public ApplicationForm getApplicationForm(long sessionID) throws InvalidSessionIDException{
        
        //check that the session id exists and that it was created less than 10 minutes ago
        if (!(ids.containsKey(sessionID))) {
            throw new InvalidSessionIDException("Invalid session ID");
        }
        else if (System.currentTimeMillis() > (ids.get(sessionID) + 600000L)){
            throw new InvalidSessionIDException("Session timed out");
        }
        return new ApplicationFormV1();
    }

    // Implementation of submitApplicationForm method - writing the application form to a file
    @Override
    public void submitApplicationForm(long sessionID, ApplicationForm form) {
        try {
            String firstName = form.getAnswer(1);
            String secondName = form.getAnswer(2);
            Files.write(Paths.get("application_form_" + firstName + "_" + secondName + ".txt"), 
                form.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

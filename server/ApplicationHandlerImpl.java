package server;

import interfaces.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import exceptions.*;

public class ApplicationHandlerImpl implements ApplicationHandler {
    // Implementation of login method - checking if the (hardcoded) username and password are correct
    @Override
    public long login(String username, String password) throws InvalidCredentialsException{
        // Check hardcoded username and password
        if (!username.equals("Ryan") || !password.equals("password")) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        // TODO: Return timestamp/random number as session ID and implement validation
        return 1234567890;
    }


    // Implementation of getApplicationForm method - returning an application form
    @Override
    public ApplicationForm getApplicationForm(long sessionID) throws InvalidSessionIDException{
        if (sessionID != 1234567890) {
            throw new InvalidSessionIDException("Invalid session ID");
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

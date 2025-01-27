package server;

import interfaces.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import exceptions.*;

public class ApplicationHandlerImpl implements ApplicationHandler {
    public long login(String username, String password) throws InvalidCredentialsException{
        System.out.println(username);
        System.out.println(password);
        if (!username.equals("Ryan") || !password.equals("password")) {
            throw new InvalidCredentialsException("Invalid credentials");
        }
        return 1234567890;
    }

    public ApplicationForm getApplicationForm(long sessionID) throws InvalidSessionIDException{
        if (sessionID != 1234567890) {
            throw new InvalidSessionIDException("Invalid session ID");
        }
        return new ApplicationFormV1();
    }

    public void submitApplicationForm(long sessionID, ApplicationForm form) {
        try {
            Files.write(Paths.get("application_form_" + sessionID + ".txt"), form.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import exceptions.*;

// Handles authentication, form retrieval, and form submission for the application
public interface ApplicationHandler extends Remote {
    // Login with the provided username and password - returning a session ID
    long login(String username, String password) throws RemoteException, InvalidCredentialsException;
    // Get the application form accociated with the session ID
    ApplicationForm getApplicationForm(long sessionID) throws RemoteException, InvalidSessionIDException;
    // Submit the application form asscociated with the session ID
    void submitApplicationForm(long sessionID, ApplicationForm form) throws RemoteException, InvalidSessionIDException;
}

package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import exceptions.*;

public interface ApplicationHandler extends Remote {
    long login(String username, String password) throws RemoteException, InvalidCredentialsException;
    ApplicationForm getApplicationForm(long sessionID) throws RemoteException, InvalidSessionIDException;
    void submitApplicationForm(long sessionID, ApplicationForm form) throws RemoteException, InvalidSessionIDException;
}

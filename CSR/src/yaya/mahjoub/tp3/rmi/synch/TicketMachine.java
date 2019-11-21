

import java.util.*;
import java.io.*;

import java.rmi.*;

public interface TicketMachine extends Remote
{
    public  boolean bookTickets(int nb) throws RemoteException;

 	public  boolean addNewTickets(int nb) throws RemoteException;
    
   // public int getNbBillet()throws RemoteException;
}

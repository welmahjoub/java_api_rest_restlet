
import java.util.*;
import java.io.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class Client
{
    public static void main(String args[]) {

      try {
        System.out.print("Installing security manager...");
        if (System.getSecurityManager() == null) {
          System.setSecurityManager(new SecurityManager());
        }
        System.out.println("done.");

        System.out.print("Getting the registry...");
        Registry registry = LocateRegistry.getRegistry();
        System.out.println("done.");

        System.out.print("Getting the stub...");
        TicketMachine ticketMachine = (TicketMachine)registry.lookup("ticketMachine");
        System.out.println("done.");

        System.out.print("Inovking the remote method...");
        boolean result = ticketMachine.bookTickets(5);
        
        System.out.println("achat de 5 billet : " + result);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
} // Client


import java.util.*;
import java.io.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class Manager extends Thread
{
    public  void run() {

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
        boolean result = ticketMachine.addNewTickets(5);
        
        System.out.println("ajout  de 5 billet : " + result);
        
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

} // Manager

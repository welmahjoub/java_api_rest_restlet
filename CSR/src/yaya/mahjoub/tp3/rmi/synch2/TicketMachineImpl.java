
import java.util.*;
import java.io.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class TicketMachineImpl implements TicketMachine
{
    private int nbTicket;
    private static final int BORN_INF=1;
    public TicketMachineImpl()
    {
      nbTicket=10;
    }
   

    public synchronized boolean bookTickets(int nb) throws RemoteException ,InterruptedException
    {
      System.out.println("Service invoked bookTickets on  "+nbTicket);

      while(nbTicket < nb) // tester si il ya encore des billtes
      {
        wait(); // blocker client jsuqua ce que le manager ajout des billets  
      }

      nbTicket-=nb;
      System.out.println("nb :"+nbTicket);
      notifyAll();// notify le manager
      return true;

    } 

    public synchronized boolean addNewTickets(int nb) throws RemoteException ,  InterruptedException
    {
      System.out.println(" Service invoked addNewTickets on  "+nbTicket);

      while(nbTicket > BORN_INF ) // tester si il ya encore des billtes
      {
        wait(); // blocker manager jsuqua il a plus de billet 
        
      }
        
      nbTicket+=nb;
      System.out.println("nb :"+nbTicket);
      notifyAll();// notify client
      return true;
        
    }

    public static void main(String args[])
    {

	     try {
         System.out.print("Installing security manager...");
         if (System.getSecurityManager() == null) {
           System.setSecurityManager(new SecurityManager());
         }
         System.out.println("done.");

         System.out.print("Creating the registry of RMI services...");
         LocateRegistry.createRegistry(1099);
         System.out.println("done.");

         System.out.print("Creating the remotely accessible adderImpl (and the stub)...");
         TicketMachine ticketMachine = new TicketMachineImpl();
         TicketMachine stub = (TicketMachine) UnicastRemoteObject.exportObject(ticketMachine, 0);
         System.out.println("done.");

         System.out.println("Registering the stub...");
         Registry registry = LocateRegistry.getRegistry();
         registry.rebind("ticketMachine", stub);
         System.out.println("done.");
       }
       catch(Exception re){
         re.printStackTrace();
       }
    }

} // TicketMachineImpl

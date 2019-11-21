
import java.util.*;
import java.io.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class TicketMachineImpl implements TicketMachine
{
    private int nbTicket;
    public TicketMachineImpl()
    {
      nbTicket=10;
    }
   

    public boolean bookTickets(int nb) throws RemoteException
    {
      System.out.println("Service invoked bookTickets on  "+nb);

      if(nbTicket>=nb)
      {
        nbTicket-=nb;
        return true;
      }  
       else
        return false;
    } 

    public boolean addNewTickets(int nb) throws RemoteException
    {
      System.out.println("Service invoked addNewTickets on  "+nb);
        if(nbTicket <= 1)
        {

          nbTicket+=nb;
          return true;
        }
        else
          return false;
    }

   /* public void addNewTickets(int nb) throws RemoteException
    {
      System.out.println("Service invoked addNewTickets on  "+nb);

      nbTicket+=nb;
    }*/

  /* public int getNbBillet()throws RemoteException
    {
      return nbTicket;
    }*/
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

} // AdderImpl

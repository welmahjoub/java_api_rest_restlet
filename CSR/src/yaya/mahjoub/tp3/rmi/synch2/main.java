
import java.util.*;
import java.io.*;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

class main
{
    public static void main(String[] args) {
        
        Client c=new Client();
        c.start();

        Client c2=new Client();
        c2.start();

        Manager m1=new Manager();
        m1.start();

        Manager m2=new Manager();
        m2.start();

    }

     
    
} // Client

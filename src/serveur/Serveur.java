package serveur;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import implementation.MachineServiceImpl;
import implementation.SalleServiceImpl;
import service.ISalleService;
import service.IMachineService;

public class Serveur {

	public static void main(String[] args) {
		try {

			ISalleService isalleService = new SalleServiceImpl();
			
			LocateRegistry.createRegistry(1052);
			
			Naming.bind("rmi://localhost:1099/isalleService", isalleService);

			IMachineService imachineService = new MachineServiceImpl();
			
			LocateRegistry.createRegistry(1099);
			
			Naming.bind("rmi://localhost:1099/imachineService", imachineService);

			System.out.println("En attente des clients");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

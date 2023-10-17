package serveur;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import implementation.MachineServiceImpl;
import implementation.SalleServiceImpl;
import service.ISalleService;
import service.IMachineService;

public class Serveur {

	public static void main(String[] args) {
		try {

			ISalleService salleService = new SalleServiceImpl();
			Naming.bind("rmi://localhost:1099/salleService", salleService);

			IMachineService machineService = new MachineServiceImpl();
			Naming.bind("rmi://localhost:1099/machineService", machineService);

			System.out.println("En attente des clients");
		} catch (RemoteException | MalformedURLException | AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
}

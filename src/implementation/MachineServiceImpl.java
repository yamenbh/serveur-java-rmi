package implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import client.Machine;
import service.IMachineService;

public class MachineServiceImpl extends UnicastRemoteObject implements IMachineService {

	public MachineServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
    private List<Machine> machines = new ArrayList<>();

    @Override
    public void ajouterMachine(Machine machine) {
        machines.add(machine);
    }
    
    @Override
    public void supprimerMachine(String refMachine) {
        machines.removeIf(salle -> salle.getRef().equals(refMachine));
    }

    @Override
    public List<Machine> listerMachines() {
        return machines;
    }




}

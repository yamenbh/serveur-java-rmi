package implementation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import client.Salle;
import service.ISalleService;

public class SalleServiceImpl  extends UnicastRemoteObject implements ISalleService {

	public SalleServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
    private List<Salle> salles = new ArrayList<>();

    @Override
    public void ajouterSalle(Salle salle) {
        salles.add(salle);
    }
    
    @Override
    public void supprimerSalle(String codeSalle) {
        salles.removeIf(salle -> salle.getCode().equals(codeSalle));
    }

    @Override
    public List<Salle> listerSalles() {
        return salles;
    }

}

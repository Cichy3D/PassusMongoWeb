package pl.passus.app.dao;

import java.util.List;

import pl.passus.app.model.Rekord;

public interface RekordDAO {

	public Rekord get(String pole);
	public List<Rekord> list();
	public boolean add(Rekord rekord);
	
	
}

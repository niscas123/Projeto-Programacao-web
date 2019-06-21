package repositorios;

import java.util.List;

import DAO.DAOManager;
import interfaces.InterfaceGeral;

import negocio.Artigo;

public class RepositorioArtigo implements InterfaceGeral<Artigo> {

	@Override
	public void insert(Artigo s) {
		DAOManager.persist(s);
	
	}
// nome titulo artigos jornal evento doi isbn
	@Override
	public Artigo search(String s) {
        try{
        return (Artigo)((List<Artigo>)DAOManager.recover("from Artigo where nome='"+s+"' ")).get(0);
        } catch(IndexOutOfBoundsException e) {
            return null;
        }
	}

	@Override
	public void update(Artigo s) {
		DAOManager.update(s);
		
	}

	@Override
	public void delete(Artigo s) {
		DAOManager.delete(s);
		
	}

	@Override
	public List<Artigo> Listen() {
		return DAOManager.recover("from Artigo");
	}

}

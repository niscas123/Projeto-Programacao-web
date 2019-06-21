package controller;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import negocio.Equipe;
import repositorios.RepositorioEquipe;

@ManagedBean(name = "controllerEquipe")
@SessionScoped
public class ControllerEquipe {
	RepositorioEquipe repoEquipe = new RepositorioEquipe();
	
	public void insert(Equipe s) {
		repoEquipe.insert(s);
	}
	
	public Equipe search(String s) {
		return repoEquipe.search(s);
		
	}
	
	public void update(Equipe s) {
		repoEquipe.update(s);
	}
	
	public void delete(Equipe s) {
		repoEquipe.delete(s);
	}
	
	public ArrayList<Equipe> Listen() {
		return (ArrayList)repoEquipe.Listen();
		
	}

}

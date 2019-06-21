package repositorios;

import java.util.List;

import DAO.DAOManager;
import interfaces.InterfaceGeral;
import negocio.Equipe;
import negocio.Usuario;

public class RepositorioEquipe implements InterfaceGeral<Equipe> {

    @Override
    public void insert(Equipe s) {
        DAOManager.persist(s);

    }

    // Depois a gente vê isso
    @Override
    public Equipe search(String s) {
        try {
            return (Equipe) ((List<Equipe>) DAOManager.recover("from Artigo where lider='" + s + "' or usuarios='" + s + "' ")).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public void update(Equipe s) {
        DAOManager.update(s);

    }

    @Override
    public void delete(Equipe s) {
        DAOManager.delete(s);

    }

    @Override
    public List<Equipe> Listen() {
        return DAOManager.recover("from Equipe");
    }

    public Equipe equipe(Usuario usuario) {
        try {
            return (Equipe) ((List<Equipe>) DAOManager.recover("from Equipe where lider_id='" + usuario.getId() + "'")).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

}

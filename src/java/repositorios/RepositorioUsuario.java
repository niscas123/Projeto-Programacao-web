package repositorios;

import java.util.List;

import DAO.DAOManager;
import interfaces.InterfaceGeral;
import negocio.Usuario;

public class RepositorioUsuario implements InterfaceGeral<Usuario> {

    @Override
    public void insert(Usuario s) {
        DAOManager.persist(s);

    }

    @Override
    public Usuario search(String s) {
        try {
            return (Usuario) ((List<Usuario>) DAOManager.recover("from Usuario where nome='" + s + "' ")).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public void update(Usuario s) {
        DAOManager.update(s);

    }

    @Override
    public void delete(Usuario s) {
        DAOManager.delete(s);

    }

    @Override
    public List<Usuario> Listen() {
        try {
            return DAOManager.recover("from Usuario");
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public Usuario login(String login) {
        try {
            return (Usuario) ((List<Usuario>) DAOManager.recover("from Usuario where email='" + login + "' ")).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public void persist(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

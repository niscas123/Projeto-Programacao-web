package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import negocio.Artigo;
import negocio.Equipe;
import negocio.Usuario;
import repositorios.RepositorioArtigo;
import repositorios.RepositorioEquipe;

@ManagedBean(name = "controllerArtigo")
@SessionScoped
public class ControllerArtigo {

    Usuario user = (Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("usuarioLogado");

    RepositorioArtigo repoArtigo = new RepositorioArtigo();
    RepositorioEquipe repoEquipe = new RepositorioEquipe();

    public void cadastroArtigo(Artigo artigo) {
        List<Equipe> equipeList = repoEquipe.Listen();
        Equipe e = null;

        for (int i = 0; i < equipeList.size(); i++) {
            if (equipeList.get(i).getLider().getId() == user.getId()) {
                e = equipeList.get(i);
            }
        }

        repoArtigo.insert(artigo);

    }

    public void insert(Artigo s) {
        repoArtigo.insert(s);
    }

    public Artigo search(String s) {
        return repoArtigo.search(s);

    }

    public void update(Artigo s) {
        repoArtigo.update(s);
    }

    public void delete(Artigo s) {
        repoArtigo.delete(s);
    }

    public ArrayList<Artigo> Listen() {
        return (ArrayList) repoArtigo.Listen();

    }

    public List<Artigo> listaLider() {
        List<Artigo> listaL = repoArtigo.Listen();

        List<Artigo> lista = new ArrayList<>();

        for (int i = 0; i < listaL.size(); i++) {
            if (listaL.get(i).getLider().getId() == user.getId()) {
                lista.add(listaL.get(i));
            }
        }
        return lista;
    }

}

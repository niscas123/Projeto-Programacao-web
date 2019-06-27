package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
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
        List<Equipe> arrayEquipe = repoEquipe.Listen();
        Equipe equipe = null;

        for (int i = 0; i < arrayEquipe.size(); i++) {
            if (arrayEquipe.get(i).getLider().getId() == user.getId()) {
                equipe = arrayEquipe.get(i);
            }
        }
        //artigo.setLider(user);
        repoArtigo.insert(artigo);

    }

    public List<Artigo> sorteioArtigo() {
        List<Artigo> artigoList = repoArtigo.Listen();

        int numero;
        int[] num = new int[artigoList.size()];
        Random r = new Random();

        for (int i = 0; i < num.length; i++) {
            numero = r.nextInt(artigoList.size());
            for (int j = 0; j < num.length; j++) {
                if (numero == num[j] && j != i) {
                    numero = r.nextInt(artigoList.size());
                } else {
                    num[i] = numero;
                }
            }
        }
        ArrayList<Artigo> array = new ArrayList<>();

        for (int i = 0; i < num.length; i++) {
            array.add(artigoList.get(num[i]));

            //System.out.println(artigoList.get(num[i]).getId());
        }

        return array;
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

    public List<Artigo> listaArtigo() {
        List<Artigo> artigoLista = repoArtigo.Listen();

        List<Artigo> listaN = new ArrayList<>();

        for (int i = 0; i < artigoLista.size(); i++) {
            listaN.add(artigoLista.get(i));

        }
        return listaN;
    }

}

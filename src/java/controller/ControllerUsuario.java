package controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import negocio.Equipe;
import negocio.Usuario;
import repositorios.RepositorioEquipe;
import repositorios.RepositorioUsuario;

@ManagedBean(name = "controllerUsuario")
@SessionScoped
public class ControllerUsuario {

    private int log;
    private String email;
    private String senha;

    public int getLog() {
        return log;
    }
    public void setLog(int log) {
        this.log = log;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    Usuario user = (Usuario) ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).getAttribute("usuarioLogado");

    RepositorioUsuario repoUsuario = new RepositorioUsuario();
    RepositorioEquipe repoEquipe = new RepositorioEquipe();

    public void cadastroUsuario(Usuario usuario) {
        if (usuario.getTipo().equals("lider")) {
            repoUsuario.insert(usuario);
            Usuario a = repoUsuario.search(usuario.getNome());
            Equipe e = new Equipe();
            e.setLider(a);
            e.setUsuarios((List<Usuario>) a);
            repoEquipe.insert(e);
        } else if(usuario.getTipo().equals("estagiario")) {
            repoUsuario.insert(usuario);
            Usuario a = repoUsuario.search(usuario.getNome());
            Equipe e = new Equipe();
            e.setLider(user);
            e.setUsuarios((List<Usuario>) a);
            repoEquipe.insert(e);  
        } else if(usuario.getTipo().equals("administrador")) {
            repoUsuario.insert(usuario);
        }
    }

    public void insert(Usuario s) {
        repoUsuario.insert(s);
    }

    public Usuario search(String s) {
        return repoUsuario.search(s);

    }

    public void update(Usuario s) {
        repoUsuario.update(s);
    }

    public void delete(Usuario s) {
        repoUsuario.delete(s);
    }

    public ArrayList<Usuario> Listen() {
        return (ArrayList) repoUsuario.Listen();

    }

    public String login(String login, String senha) {
        Usuario uso = repoUsuario.login(login);
        if (uso == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "usuario", "Senha ou Login não Conferem"));
            return null;
        }
        if (!uso.getSenha().equals(senha)) {
            return null;
        }
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("usuarioLogado", uso);

        JOptionPane.showMessageDialog(null, uso.getId());

        switch (uso.getTipo()) {
            case "estagiario":
                setLog(1);
                break;
            case "lider":
                setLog(2);
                break;
            case "administrador":
                setLog(3);
                break;
            default:
                setLog(0);
                break;
        }
        return "home.xhtml";
    }

}

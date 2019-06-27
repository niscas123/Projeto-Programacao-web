package negocio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* Classa responsavel por estruturar equipes
 * 
 */
@Entity
@Table(name = "equipe")
@ManagedBean(name = "equi")
@RequestScoped
public class Equipe {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Usuario lider;

    @ManyToMany
    private List<Usuario> usuarios;

    public Equipe(int id, Usuario lider, List<Usuario> usuarios) {
        this.id = id;
        this.lider = lider;
        this.usuarios = usuarios;
    }

    public Equipe() {

    }

    public int getId() {
        return id;
    }
    
    public Usuario getLider() {
        return lider;
    }
    public void setLider(Usuario lider) {
        this.lider = lider;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}

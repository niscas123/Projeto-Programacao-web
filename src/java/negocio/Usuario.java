package negocio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/* Classe responsavel por compor os dados do usuario 
 * 
 */
@Entity
@Table(name = "usuario")
@ManagedBean(name = "usu")
@RequestScoped
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "cpf", length = 30, unique = true)
    private String cpf;

    @Column(name = "senha", length = 255)
    private String senha;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "tipo", length = 255)
    private String tipo;
    
    public Usuario(int id, String nome, String cpf, String senha, String email, String tipo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}

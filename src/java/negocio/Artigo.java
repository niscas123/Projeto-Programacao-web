package negocio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "artigo")
@ManagedBean(name = "art")
@RequestScoped
public class Artigo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "nome", length = 255)
    private String nome;

    @Column(name = "titulo", length = 255)
    private String titulo;

    @Column(name = "publicacao", length = 255)
    private String publicacao;

    @Column(name = "ano", length = 10)
    private int ano;

    @Column(name = "paginas", length = 10)
    private int paginas;

    @Column(name = "doi", length = 15)
    private String doi;

    @Column(name = "isbn", length = 15)
    private int isbn;
    
    @OneToOne
    private Usuario lider;

    public Artigo(int id, String nome, String titulo, String publicacao, int ano, int paginas,
            String doi, int isbn, Usuario lider) {
        this.id = id;
        this.nome = nome;
        this.titulo = titulo;
        this.publicacao = publicacao;
        this.ano = ano;
        this.paginas = paginas;
        this.doi = doi;
        this.isbn = isbn;
        this.lider = lider;
    }

    public Artigo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Usuario getLider() {
        return lider;
    }
    public void setLider(Usuario lider) {
        this.lider = lider;
    }

}

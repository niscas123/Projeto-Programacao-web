package DAO;

import java.util.ArrayList;

import negocio.Artigo;
import negocio.Equipe;
import negocio.Usuario;
import repositorios.RepositorioArtigo;
import repositorios.RepositorioEquipe;
import repositorios.RepositorioUsuario;

public class Teste {

	public static void main(String[] args) {
		RepositorioUsuario testeUsuario = new RepositorioUsuario();
		
		/*Usuario a = new Usuario();
		
		a.setNome("Clayton");
		a.setEmail("clayton@gmail.com");
		a.setSenha("12345");
		a.setTipo("Estagiário");
		
		testeUsuario.insert(a);*/
		
		/*ArrayList<Usuario> arrayUsuario = (ArrayList<Usuario>) testeUsuario.Listen();
		
		for(int i = 0; i < arrayUsuario.size(); i++) {
			System.out.println(arrayUsuario.get(i).getNome());
		}*/
		
		//Usuario b = testeUsuario.search("Trio da Huana");
		//b.setNome("Trio da Huana");
		
		//testeUsuario.update(b);
		//testeUsuario.delete(b);
		
		//System.out.println(b.getEmail());
		
		/*RepositorioArtigo testeArtigo = new RepositorioArtigo();
		
		ArrayList<Artigo> arrayArtigo = (ArrayList<Artigo>) testeArtigo.Listen();
		
		for(int i = 0; i < arrayArtigo.size(); i++) {
			System.out.println(arrayArtigo.get(i).getNome());
		}*/
		
		/*/Artigo b = new Artigo();
		
		b.setNome("Andersson");
		b.setTitulo("Sabão");
		b.setArtigos("Bosta");
		b.setPublicacao("Jornal");
		b.setAno(2018);
		b.setPaginas(5);
		b.setDoi("asdassasada");
		b.setIsbn(648964894);	
		
		testeArtigo.insert(b);
		System.out.println(b.getNome());*/
		
		/*Artigo c = testeArtigo.search("Nicollas");

		//c.setNome("Nicollas");
		//testeArtigo.update(c);
		testeArtigo.delete(c);
		
		System.out.println(c.getNome());*/
		
		
		RepositorioEquipe testeEquipe = new RepositorioEquipe();
		
		Equipe d = new Equipe();
		
		Usuario usuario = testeUsuario.search("Josenaldo");
		
		ArrayList<Usuario> arrayUsu = new ArrayList<>();
		
		Usuario usuario1 = testeUsuario.search("Clesbsu");
		Usuario usuario2 = testeUsuario.search("Clayton");
		
		arrayUsu.add(usuario1);
		arrayUsu.add(usuario2);
		
		d.setLider(usuario);
		d.setUsuarios(arrayUsu);
		
		//testeEquipe.insert(d);
		
		ArrayList<Equipe> arrayEquipe = (ArrayList<Equipe>) testeEquipe.Listen();
		
		for(int i = 0; i < arrayEquipe.size(); i++) {
			System.out.println("Lider da Equipe: " + arrayEquipe.get(i).getLider().getNome());
			for(int j = 0; j < arrayEquipe.get(i).getUsuarios().size(); j++) {
				System.out.println("Estagiário: " + arrayEquipe.get(i).getUsuarios().get(j).getNome());
			}
			
		}

	}

}

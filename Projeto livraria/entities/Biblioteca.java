package entities;

import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
	private List<Livros> livros = new ArrayList<>() ;
	private List<Autor> autores = new ArrayList<>() ;
	private List<Emprestimos> emprestimos = new ArrayList<>();
	
	
	//Gerenciamento de livros
	
	public void addLivro(Livros livro) {
		livros.add(livro);		
	}
	public void removeLivro(int id_livro) {
		livros.removeIf(l -> l.getId_livro() == id_livro);
	}
	public List<Livros> listarLivros(){
		return livros;
	}
	public List<Livros> listarLivrosDisponiveis(){
		List<Livros> livrosDisponiveis = new ArrayList<>();
		for(Livros livro : livros) {
			if (livro.isDisponivel()) {
				livrosDisponiveis.add(livro);				
			}			
		}
		return livrosDisponiveis;		
	}
	public Livros buscarLivroPorId(int id) {
        for (Livros livro : livros) {
            if (livro.getId_livro() == id) {
                return livro;
            }
        }
        return null;
    }
	
	public void atualizarLivro(int id, String novoTitulo) {
        for (Livros livro : livros) {
            if (livro.getId_livro() == id) {
                livro.setTitulo(novoTitulo);
                break;
            }
        }
    }
	
	// Gerenciamento dos autores
	public void addAutor(Autor autor) {
		autores.add(autor);
	}
	public void removeAutor(int id) {
		autores.removeIf(x -> x.getId() == id);
	}
	// Métodos para gerenciar empréstimos
    public void emprestarLivro(Livros livro, String nomeUsuario) {
        if (livro.isDisponivel()) {
            Emprestimos emprestimo = new Emprestimos(livro, nomeUsuario);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }

    public void devolverLivro(int idEmprestimo) {
        for (Emprestimos emprestimo : emprestimos) {
            if (emprestimo.getId() == idEmprestimo && emprestimo.isAtivo()) {
                emprestimo.devolverLivro();
                break;
            }
        }
    }

    public List<Emprestimos> listarEmprestimos() {
        return emprestimos;
    }		

}

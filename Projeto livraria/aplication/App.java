package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Autor;
import entities.Biblioteca;
import entities.Livros;

public class App {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();

		Autor autor1 = new Autor(1, "Fulano", new Date());
		Autor autor2 = new Autor(2, "Deutrano", new Date());

		biblioteca.addAutor(autor1);
		biblioteca.addAutor(autor2);

		Livros livro1 = new Livros(1, "Livro de número 1", autor1);
		Livros livro2 = new Livros(2, "Livro de número 2", autor2);
		Livros livro3 = new Livros(3, "Livro de número 3", autor1);

		biblioteca.addLivro(livro1);
		biblioteca.addLivro(livro2);
		biblioteca.addLivro(livro3);

		while (true) {
			System.out.println("Deseja ver os livros disponíveis? (sim/nao)");
			String resposta = scanner.nextLine().toLowerCase();

			if (resposta.equals("sim")) {
				List<Livros> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

				if (livrosDisponiveis.isEmpty()) {
					System.out.println("Não há livros disponíveis no momento.");
				} else {
					System.out.println("Livros disponíveis:");
					for (Livros livro : livrosDisponiveis) {
						System.out.println(livro.getId_livro() + ": " + livro.getTitulo());
					}

					System.out.println("Digite o ID do livro que você deseja emprestar:");
					int idLivro = scanner.nextInt();
					scanner.nextLine();

					Livros livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

					if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
						System.out.println("Digite seu nome:");
						String nomeUsuario = scanner.nextLine();

						biblioteca.emprestarLivro(livroSelecionado, nomeUsuario);
						System.out.println(
								"O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario);
					} else {
						System.out.println("Livro não encontrado ou não disponível para empréstimo.");
					}
				}
				
			} else if (resposta.equals("nao")) {
				System.out.println("Obrigado por utilizar o sistema!");
				break;
				
			} else {
				System.err.println("Resposta inválida. Por favor, responda com 'sim' ou 'não'.");
			}
		}

		scanner.close();

	}

}

package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Livros {
	private Integer id_livro;
	private Autor autor;
	private String titulo;
	private boolean disponivel;
	private Date dataCadastro;
	private Date dataAtualizacao;

	
	public Livros() {

	}

	public Livros(Integer id_livro, String titulo,Autor autor) {

		this.id_livro = id_livro;
		this.autor = autor;
		this.titulo = titulo;
		this.disponivel = true;
	
	}

	public Integer getId_livro() {
		return id_livro;
	}
			

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public void setId_livro(Integer id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	@Override
    public String toString() {
        return "Livro{" +
                "id=" + id_livro +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", disponivel=" + disponivel +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }


	
	
}
	


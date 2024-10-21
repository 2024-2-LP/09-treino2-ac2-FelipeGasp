package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;
import school.sptech.exception.LivroNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca(List<Livro> livro, String nome) {
        this.livros = livro;
        this.nome = nome;
    }

    public Biblioteca() {
    }

    public void adicionarLivro(Livro livro) throws ArgumentoInvalidoException {
        if (livro == null) {
            throw new ArgumentoInvalidoException();
        }
        if (livro.getTitulo() == null) {
            throw new ArgumentoInvalidoException();
        }
        if (livro.getDataPublicacao() == null) {
            throw new ArgumentoInvalidoException();
        }
        if (livro.getAutor() == null){
            throw new ArgumentoInvalidoException();

        }
        this.livros.add(livro);

    }

    public void removerLivroPorTitulo(String titulo) throws ArgumentoInvalidoException {
        if (titulo == null || titulo.isEmpty() || titulo.isEmpty()) {
            throw new ArgumentoInvalidoException();
        }
        List<Livro> livrosRemovidos = new ArrayList<>();
        List<Livro> livrosParaRemover = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                livrosParaRemover.add(livro);
                livrosRemovidos.add(livro);
            }
        }
        this.livros.removeAll(livrosParaRemover);
        
        if (livrosRemovidos.isEmpty()) {
            throw new ArgumentoInvalidoException();
        }

    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo == null || titulo.isEmpty() || titulo.isEmpty()) {
            throw new ArgumentoInvalidoException();
        }
        String titulo2 = titulo.toLowerCase();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo2)) {
                return livro;
            }
        }
        throw new LivroNaoEncontradoException();
    }
    public Integer contarLivros(){
        return livros.size();
    }
    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> listaLivroAnos = new ArrayList<>();
        for(Livro livro : livros){
            if(livro.getDataPublicacao().getYear() == ano){
                listaLivroAnos.add(livro);
            }
        }
        return listaLivroAnos;
    }

    public List<Livro> getLivro() {
        return livros;
    }

    public void setLivro(List<Livro> livro) {
        this.livros = livro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

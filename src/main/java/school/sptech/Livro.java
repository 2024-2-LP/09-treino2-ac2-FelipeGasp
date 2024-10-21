package school.sptech;

import school.sptech.exception.ArgumentoInvalidoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        avaliacoes = avaliacao;
    }

    public Livro(String titulo, String autor, LocalDate dataPublicacao, List<Avaliacao> avaliacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        avaliacoes = avaliacao;
    }

    public Livro() {
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) throws ArgumentoInvalidoException {
        if (descricao == null || descricao.isBlank() || descricao.isEmpty()) {
            throw new ArgumentoInvalidoException("Argumento passado não é válido!");
        }
        if (qtdEstrelas < 0 || qtdEstrelas > 5 || qtdEstrelas == null) {
            throw new ArgumentoInvalidoException("Argumento passado não é válido!");
        }
        Avaliacao avaliacaoToAdd = new Avaliacao(descricao, qtdEstrelas);
        avaliacoes.add(avaliacaoToAdd);
    }
    public Double calcularMediaAvaliacoes(){
        Double media = 0.0;
        for (int i = 0; i < avaliacoes.size(); i++) {
            Avaliacao avaliacaoDaVez = avaliacoes.get(i);
            media+= avaliacaoDaVez.getQtdEstrelas();
        }
        return media/avaliacoes.size();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public List<Avaliacao> getAvaliacao() {
        return avaliacoes;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacao=" + avaliacoes +
                '}';
    }
}

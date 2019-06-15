package local.model;

import local.exception.FilmeException;

public class Filme {


    private String nome;
    private Integer estoque;
    private Double precoLocacao;

    public Filme() {
    }

    public Filme(String nome, Integer estoque, Double precoLocacao) {
        this.nome = nome;
        this.estoque = estoque;
        this.precoLocacao = precoLocacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Integer getEstoque() {
        if(estoque > 99){
            throw new FilmeException("Valor de estoque inválido");
        }
        return estoque;
    }

    public void setEstoque(Integer estoque) throws FilmeException{

        if(estoque > 99 || estoque < 0){
            throw new FilmeException("Valor de estoque inválido");
        }


        this.estoque = estoque;
    }


    public Double getPrecoLocacao() {
        return precoLocacao;
    }

    public void setPrecoLocacao(Double precoLocacao) {
        this.precoLocacao = precoLocacao;
    }
}

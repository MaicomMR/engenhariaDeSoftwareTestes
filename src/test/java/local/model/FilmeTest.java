package local.model;

import local.exception.FilmeException;
import local.exception.FilmeSemEstoqueException;
import local.exception.LocacaoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.CoreMatchers.*;

public class FilmeTest {
    //TODO: Nome deve possuir entre 2 e 99 caracteres (inclusive)
    // Lança FilmeException - O nome do filme deve possuir entre 2 e 99 caracteres

@Test
@DisplayName("Nome do filme em tamanho correto")
        public void nomeDoFilmeOk (){

        //Cenário
        String nomeFilme = "ETBilu";
        Filme filme = new Filme();
        //Ação
        filme.setNome(nomeFilme);
        //Validação
        assertEquals(filme.getNome(), nomeFilme);
}
    //TODO: Estoque não pode ser negativo, e o máximo é 99 (inclusive)
    // Lança FilmeException - Valor de estoque inválido
    @Test
    @DisplayName("Estoque Superior a 99")
    public void estoqueSuperior () throws FilmeException{

        int estoqueQtd = 100;

        //Cenário estoque > 99
        Filme filme = new Filme();

        //Validação
        Exception ex = assertThrows(FilmeException.class,()-> filme.setEstoque(estoqueQtd));
        assertEquals("Valor de estoque inválido", ex.getMessage());
        }

    @Test
    @DisplayName("Estoque Negativo")
    public void estoqueNegativo () throws FilmeException{

        int estoqueQtd = -1;

        //Cenário estoque > 99
        Filme filme = new Filme();

        //Validação
        Exception ex = assertThrows(FilmeException.class,()-> filme.setEstoque(estoqueQtd));
        assertEquals("Valor de estoque inválido", ex.getMessage());
    }


    @Test
    @DisplayName("Locação com valor menor que 1,00R$")
    public void locacaoMenorQueUm() throws LocacaoException {
    double valor = 0.90;

    Locacao locacao = new Locacao();

        Exception ex = assertThrows(LocacaoException.class,()-> locacao.setValor(valor));
        assertEquals("O valor da Locação devem ser maior que 1,00R$ e menor que 10,00R$", ex.getMessage());
    }
    @Test
    @DisplayName("Locação com valor maior que 10,00R$")
    public void locacaoMaiorQueDez() throws LocacaoException {
        double valor = 10.01;

        Locacao locacao = new Locacao();

        Exception ex = assertThrows(LocacaoException.class,()-> locacao.setValor(valor));
        assertEquals("O valor da Locação devem ser maior que 1,00R$ e menor que 10,00R$", ex.getMessage());
    }
//TODO: O preço de Locacao deverá ser um número positivo entre R$ 1,00 e R$ 9,99 (inclusive)
    // Lança FilmeException - Valor locação inválido

}

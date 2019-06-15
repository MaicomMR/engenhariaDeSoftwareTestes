package local.model;

import local.exception.ClienteException;
import local.exception.LocadoraException;
import local.service.LocacaoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest extends Throwable {

    @Test
    @DisplayName("Nome não pode ser nulo!!")
    public void nomeNaoPodeSerNulo() {
        String nome = null;

        Cliente cliente = new Cliente(nome);
        //Throwable exception = assertThrows(ClienteException.class, () -> cliente(nome));
        //assertEquals("expected messages", exception.getMessage());

        Throwable exception = assertThrows(ClienteException.class, () -> cliente.setNome(nome));
        assertEquals("Nome não é um campo obrigatório", exception.getMessage());

    }

    @Test
    @DisplayName("Nome < 4 caracteres")
    public void nomeMenorQueQuatroCaracteres() {
        String nome = "abc";

        Cliente cliente = new Cliente(nome);

        Throwable exception = assertThrows(ClienteException.class, () -> cliente.setNome(nome));
        assertEquals("O nome do cliente deve possuir entre 4 e 55 caracteres", exception.getMessage());

    }
    @Test
    @DisplayName("Nome > 55 caracteres")
    public void nomeMaiorQueCinquentaECincoCaracteres() {
        String nome = "12345678901234567890123456789012345678901234567890123456";

        Cliente cliente = new Cliente(nome);

        Throwable exception = assertThrows(ClienteException.class, () -> cliente.setNome(nome));
        assertEquals("O nome do cliente deve possuir entre 4 e 55 caracteres", exception.getMessage());

    }
    @Test
    @DisplayName("Nome e Sobrenome")
    public void DoisNomesOuMais() {
        String nome = "Maicom";

        Cliente cliente = new Cliente(nome);

        Throwable exception = assertThrows(ClienteException.class, () -> cliente.setNome(nome));
        assertEquals("É necessário adicionar um sobrenome", exception.getMessage());
    }
    @Test
    @DisplayName(" Remoção de Espaços nas extremidades do Nome ")
    public void nomeComEspacoNasExtremidades() {
        String nome = " Maicom  Rodeghiero ";
        String nomeWithouSpaces = "Maicom  Rodeghiero";
        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        assertEquals(cliente.getNome(), nomeWithouSpaces);
    }
    @Test
    @DisplayName("Nome com números")
    public void nomeComNumeros() {
        String nome = "Maicom112123";

        Cliente cliente = new Cliente(nome);

        Throwable exception = assertThrows(ClienteException.class, () -> cliente.setNome(nome));
        assertEquals("Números e símbolos não são permitidos", exception.getMessage());
    }
    @Test
    @DisplayName("Nome com símbolos")
    public void nomeComSimbolos() {
        String nome = "Maicom@@@";

        Cliente cliente = new Cliente(nome);

        Throwable exception = assertThrows(ClienteException.class, () -> cliente.setNome(nome));
        assertEquals("Números e símbolos não são permitidos", exception.getMessage());
    }
    @Test
    @DisplayName("Nome Padrão")
    public void nomePadrao() {
        String nome = "Maicom M Rodeghiero";

        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        assertEquals(cliente.getNome(), nome);
    }
}

package local.model;

import local.exception.LocacaoException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Locacao {

	private Cliente cliente;
	private List<Filme> filmes;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;

	public Locacao(){
		filmes = new ArrayList<>();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) throws LocacaoException {
		this.valor = valor;

		//Validação do valor do aluguel
		if (valor < 1.0 || valor > 9.99){
			throw new LocacaoException("O valor da Locação devem ser maior que 1,00R$ e menor que 10,00R$");
		}
	}
	public List<Filme> getFilmes() {
		return filmes;
	}
	public void addFilme(Filme filme){
		filmes.add(filme);
	}
}
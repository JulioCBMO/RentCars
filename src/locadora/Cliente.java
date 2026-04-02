package locadora;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	private String nome;
	private List<Locacao> carrosAlugados = new ArrayList<Locacao>();

	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void adicionaLocacao(Locacao locacao) {
		carrosAlugados.add(locacao);
	}

	public String extrato() {
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeLocadorFrequente = 0;
		int sequencia = 0;

		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "Registro de Locações de " + getNome() + fimDeLinha;
		resultado += String.format("Seq Automovel             Ano  Diarias   Valor Pago" + fimDeLinha);
		resultado += String.format("=== ==================== ===== ========= ===========" + fimDeLinha);

		while (locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			double valorDaLocacao = cada.valorDeUmaLocacao();
			pontosDeLocadorFrequente += cada.pontosDeAlugadorFrequente();
			sequencia++;
			resultado += cada.linhaExtrato(sequencia, fimDeLinha);
			valorTotal += valorDaLocacao;

		}

		// adiciona rodapé
		resultado += "====================================================" + fimDeLinha;
		resultado += String.format("Valor Acumulado em diarias............:  R$ %8.2f" + fimDeLinha, valorTotal);
		resultado += "Voce acumulou " + pontosDeLocadorFrequente +
				" pontos de locador frequente";

		return resultado;

	}

	public String extratoHTML() {
		final String fimDeLinha = System.getProperty("line.separator");
		double valorTotal = 0.0;
		int pontosDeLocadorFrequente = 0;
		int sequencia = 0;
		Iterator<Locacao> locacoes = carrosAlugados.iterator();
		String resultado = "<html><body>" + fimDeLinha;
		resultado += String.format("<H2>Registro de Locacoes de <EM>%s</EM></H2>", getNome()) + fimDeLinha;
		resultado += "<table border=\"1\"><tr><th>Seq</th><th>Automóvel</th><th>Ano</th><th>Diárias</th><th>Valor</th></tr>" + fimDeLinha;
		while (locacoes.hasNext()) {
			Locacao cada = locacoes.next();
			sequencia++;
			valorTotal += cada.valorDeUmaLocacao();
			pontosDeLocadorFrequente += cada.pontosDeAlugadorFrequente();
			resultado += String.format("<tr><th>%02d.</th><td>%s</td><td>%4d</td><td>%2d</td><td>R$%8.2f</td></tr>" + fimDeLinha,
				sequencia, cada.getCarro().getDescricao(), cada.getCarro().getAno(), cada.getDiasAlugado(), cada.valorDeUmaLocacao());
		}
		resultado += String.format("<tfoot><tr><td colspan=\"4\">Valor Acumulado em diárias:</td><td><EM>R$ %8.2f</EM></td></tr></tfoot></table>" + fimDeLinha, valorTotal);
		resultado += "<p>Você acumulou <EM>" + pontosDeLocadorFrequente + "</EM> pontos de locador frequente</p></body></html>";
		return resultado;
	}


}
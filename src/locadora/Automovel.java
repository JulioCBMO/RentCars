

package locadora;

public class Automovel implements alugavel {
	public static final int BASICO = 0;   // Carros hatch
	public static final int FAMILIA = 1;  // Carros Sedan ou SUV básico
	public static final int LUXO = 2;     // Carros padrão luxo

	private String descricao;
	private String placa;
	private int ano; // Ano de fabricacao
	private Classificacao classificacao;

	public Automovel(String descricao, int ano, String placa, Classificacao classificacao) {
		this.descricao = descricao;
		this.placa = placa;
		this.ano = ano;
		this.classificacao = classificacao;
	}

	public Automovel(String descricao, int ano, String placa, int codigoDoPreco) {
		this(descricao, ano, placa, converterClassificacao(codigoDoPreco));
	}

	private static Classificacao converterClassificacao(int codigoDoPreco) {
		switch (codigoDoPreco) {
			case BASICO:
				return new Basico();
			case FAMILIA:
				return new Familia();
			case LUXO:
				return new Luxo();
			default:
				throw new IllegalArgumentException("Código de preço inválido: " + codigoDoPreco);
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public String getPlaca() {
		return placa;
	}

	public int getAno() {
		return ano;
	}

	public int getCodigoDoPreco() {
		return classificacao.getCodigoDoPreco();
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	@Override
	public double getValorDaLocacao(int diasAlugados) {
		return classificacao.getValorDaLocacao(diasAlugados);
	}

	@Override
	public int getPontosDeAlugadorFrequente(int diasAlugados) {
		return classificacao.getPontosDeAlugadorFrequente(diasAlugados);
	}
}
package locadora;

public class Luxo extends Classificacao {
    @Override
    int getCodigoDoPreco() {
        return Automovel.LUXO;
    }

    @Override
    double getValorDaLocacao(int diasAlugado) {
        return diasAlugado * 200.0;
    }

    @Override
    int getPontosDeAlugadorFrequente(int diasAlugado) {
	return 2;
    }
}

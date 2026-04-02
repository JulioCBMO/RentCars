package locadora;

public class Familia extends Classificacao {
    @Override
    int getCodigoDoPreco() {
        return Automovel.FAMILIA;
    }

    @Override
    double getValorDaLocacao(int diasAlugado) {
        return diasAlugado * 130.0;
    }
    
    int getPontosDeAlugadorFrequente(int diasAlugado) {
	return 1;
}
}
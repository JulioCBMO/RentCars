package locadora;

public class Basico extends Classificacao {
    @Override
    int getCodigoDoPreco() {
        return Automovel.BASICO;
    }

    @Override
    double getValorDaLocacao(int diasAlugado) {
        return diasAlugado * 90.0;
    }
    
}

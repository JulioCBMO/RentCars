package locadora;

public class Locacao {
   private Automovel carro;
   private int diasAlugado;

   public Locacao(Automovel carro, int diasAlugado) {
      this.carro = carro;
      this.diasAlugado = diasAlugado;
   }

   public Automovel getCarro() {
      return carro;
   }

   public int getDiasAlugado() {
      return diasAlugado;
   }

   public double valorDeUmaLocacao() {
      return carro.getValorDaLocacao(diasAlugado);
   }

   public int pontosDeAlugadorFrequente() {
      return carro.getPontosDeAlugadorFrequente(diasAlugado);
   }

   // Mantém compatibilidade: delega ao método extraído
   public double getValorTotal() {
      return valorDeUmaLocacao();
   }

   // Método extraído com nomes descritivos para comunicar intenção


   public String linhaExtrato(int seq, String fimDeLinha){
      return String.format("%02d. %-20s  %4d    %2d     R$ %8.2f"+fimDeLinha, seq, carro.getDescricao(), carro.getAno(), diasAlugado, valorDeUmaLocacao());
   }

}

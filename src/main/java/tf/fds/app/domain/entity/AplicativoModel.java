package tf.fds.app.domain.entity;

public class AplicativoModel {
   private long codigo;
   private String nome;
   private double custoMensal;
   
   public AplicativoModel(long codigo, String nome, double custoMensal) {
      this.codigo = codigo;
      this.nome = nome;
      this.custoMensal = custoMensal;
   }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoMensal() {
        return custoMensal;
    }

    public void setCustoMensal(double custoMensal) {
        this.custoMensal = custoMensal;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Nome: " + nome + ", Custo Mensal: " + custoMensal;
    }
}

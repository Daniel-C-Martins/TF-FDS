package tf.fds.app.domain.entity;

import java.util.Date;

public class PagamentoModel {
    private long codigo;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;
    
    public PagamentoModel(long codigo, double valorPago, Date dataPagamento, String promocao) {
        this.codigo = codigo;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }
    
    public String toString(){
        return "Codigo: " + codigo + ", Valor Pago: " + valorPago + ", Data Pagamento: " + dataPagamento + ", Promocao: " + promocao;
    }
}

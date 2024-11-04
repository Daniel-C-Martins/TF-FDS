package tf.fds.app.domain.entity;

import java.util.Date;

public class AssinaturaModel {
    private long codigo;
    private Date inicioVigencia;
    private Date fimVigencia;

    public AssinaturaModel(long codigo, Date inicioVigencia, Date fimVigencia) {
        this.codigo = codigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public String toString() {
        return "Codigo: " + codigo + ", Inicio Vigencia: " + inicioVigencia + ", Fim Vigencia: " + fimVigencia;
    }
}

package tf.fds.app.domain.entities;

/**
 * Entidade que representa um aplicativo.
 */
public class ApplicativeModel {
    private long code;
    private String name;
    private double monthlyCost;

    public ApplicativeModel() {
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }
}

package tf.fds.app.domain.entity;

public class ApplicativeModel {
    private long code;
    private String name;
    private double monthlyCost;

    public ApplicativeModel(long code, String name, double monthlyCost) {
        this.code = code;
        this.name = name;
        this.monthlyCost = monthlyCost;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name + ", Custo Mensal: " + monthlyCost;
    }
}

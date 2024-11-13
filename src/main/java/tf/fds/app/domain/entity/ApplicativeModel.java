package tf.fds.app.domain.entity;

import java.util.List;

public class ApplicativeModel {
    private long code;
    private String name;
    private double monthlyCost;
    private List <SignatureModel> signature;

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

    public List<SignatureModel> getSignature() {
        return signature;
    }

    public void setSignature(List<SignatureModel> signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name + ", Custo Mensal: " + monthlyCost;
    }
}

package tf.fds.app.domain.entity;

import java.util.LinkedList;
import java.util.List;

public class ApplicativeModel {
    private long code;
    private String name;
    private double monthlyCost;
    private List <SignatureModel> signatures;

    public ApplicativeModel(long code, String name, double monthlyCost) {
        this.code = code;
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.signatures = new LinkedList<>();
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

    public List<SignatureModel> getSignatures() {
        return signatures;
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

    public void setSignatures(List<SignatureModel> signatures) {
        this.signatures = signatures;
    }
}

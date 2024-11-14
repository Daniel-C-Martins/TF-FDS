package tf.fds.app.application.dtos;

import java.util.LinkedList;
import java.util.List;

import tf.fds.app.domain.entity.ApplicativeModel;

public class ApplicativeDTO {
    private long code;
    private String name;
    private double monthlyCost;
    private List<SignatureDTO> signatures;

    public ApplicativeDTO(ApplicativeModel applicativeModel) {
        this.code = applicativeModel.getCode();
        this.name = applicativeModel.getName();
        this.monthlyCost = applicativeModel.getMonthlyCost();
        this.signatures = new LinkedList<>();

        applicativeModel.getSignatures().stream().forEach(sModel -> signatures.add(new SignatureDTO(sModel)));
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

    public List<SignatureDTO> getSignatures() {
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

    public void setSignatures(List<SignatureDTO> signatures) {
        this.signatures = signatures;
    }

    @Override
    public String toString() {
        return "ApplicativeDTO: code = " + code + ", name = " + name + ", monthlyCost = " + monthlyCost + ", signatures = "
                + signatures;
    }
}

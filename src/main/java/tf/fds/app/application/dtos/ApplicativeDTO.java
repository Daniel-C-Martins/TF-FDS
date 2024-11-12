package tf.fds.app.application.dtos;

import tf.fds.app.domain.entity.ApplicativeModel;

public class ApplicativeDTO {
    private long code;
    private String name;
    private double monthlyCost;

    public ApplicativeDTO(ApplicativeModel applicativeModel) {
        this.code = applicativeModel.getCode();
        this.name = applicativeModel.getName();
        this.monthlyCost = applicativeModel.getMonthlyCost();
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

    public ApplicativeDTO fromModel(ApplicativeModel applicativeModel) {
        return new ApplicativeDTO(applicativeModel);
    }

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name + ", Custo Mensal: " + monthlyCost;
    }
}

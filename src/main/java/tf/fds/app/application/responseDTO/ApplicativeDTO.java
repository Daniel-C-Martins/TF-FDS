package tf.fds.app.application.responseDTO;

import tf.fds.app.domain.entities.ApplicativeModel;

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

    @Override
    public String toString() {
        return "ApplicativeDTO: code = " + code + ", name = " + name + ", monthlyCost = " + monthlyCost;
    }
}

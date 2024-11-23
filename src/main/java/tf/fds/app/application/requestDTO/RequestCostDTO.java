package tf.fds.app.application.requestDTO;

public class RequestCostDTO {
   private double newCost;

   public RequestCostDTO(double newCost) {
      this.newCost = newCost;
   }

   public RequestCostDTO() {
   }

   public double getNewCost() {
      return newCost;
   }
}

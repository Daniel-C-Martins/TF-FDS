package tf.fds.app.application.requestDTO;

/*
 * DTO utilizado para receber o novo custo de um aplicativo como request body
 * @param newCost
 */
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

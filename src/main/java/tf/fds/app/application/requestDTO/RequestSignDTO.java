package tf.fds.app.application.requestDTO;

/**
 * DTO utilizado para receber a assinatura de um cliente como request body
 * @param clientCode
 * @param applicativeCode
 */
public class RequestSignDTO {
   private long clientCode;
   private long applicativeCode;

   public RequestSignDTO(long clientCode, long applicativeCode) {
      this.clientCode = clientCode;
      this.applicativeCode = applicativeCode;
   }

   public long getClientCode() {
      return clientCode;
   }

   public long getApplicativeCode() {
      return applicativeCode;
   }

   @Override
   public String toString() {
      return "RequestSignDTO - Código do cliente = " + clientCode + ", Código do aplicativo = " + applicativeCode;
   }
}

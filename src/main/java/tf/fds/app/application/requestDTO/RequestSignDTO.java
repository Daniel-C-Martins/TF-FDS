package tf.fds.app.application.requestDTO;

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
}

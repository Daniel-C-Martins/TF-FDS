package tf.fds.app.application.requestDTO;

public class RequestPayDTO {
   private int day;
   private int month;
   private int year;
   private long signatureCode;
   private double value;
   private String sale;

   public RequestPayDTO(int day, int month, int year, long signatureCode, double value, String sale) {
      this.day = day;
      this.month = month;
      this.year = year;
      this.signatureCode = signatureCode;
      this.value = value;
      this.sale = sale;
   }

   public int getDay() {
      return day;
   }
   
   public int getMonth() {
      return month;
   }

   public int getYear() {
      return year;
   }

   public long getSignatureCode() {
      return signatureCode;
   }

   public double getValue() {
      return value;
   }

   public String getSale() {
      return sale;
   }

   public void setSale(String sale) {
      this.sale = sale;
   }
}

package tf.fds.app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.repositories.IPaymentRepository;

@Service
public class PaymentService {
   private IPaymentRepository paymentRep;

   @Autowired
   public PaymentService(IPaymentRepository paymentRep) {
      this.paymentRep = paymentRep;
   }

   PaymentModel registerPayment(PaymentModel payment) {
      applyPromotion(payment);
      return paymentRep.registerPayment(payment);
   }

   private boolean applyPromotion(PaymentModel payment) {
        if(payment.getSale().equals("none")){
            return true;
        }
        //Black Friday
        if(payment.getSale().equals("BLK50")){
            if(payment.getPaymentDate().getMonthValue() == 11 && payment.getPaymentDate().getDayOfMonth() >= 21 ){
                payment.setPayedValue(payment.getPayedValue() * 0.5);
                return true;
            }
            return false;
        }

        //Natal
        if(payment.getSale().equals("NATAL65")){
            if(payment.getPaymentDate().getMonthValue() == 12 && payment.getPaymentDate().getDayOfMonth() <= 25){
                payment.setPayedValue(payment.getPayedValue() * 0.65);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusYears(1));
                return true;
            }
            return false;
        }
        //Inicio de ano
        if(payment.getSale().equals("ANO75")){
            if(payment.getPaymentDate().getMonthValue() == 1 && payment.getPaymentDate().getDayOfMonth() >= 1 && payment.getPaymentDate().getDayOfMonth() <= 29){
                payment.setPayedValue(payment.getPayedValue() * 0.75);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(35));
                return true;
            }
            return false;
        }
        //Carnaval
        if(payment.getSale().equals("CARNAVAL60")){
            if(payment.getPaymentDate().getMonthValue() == 2 && payment.getPaymentDate().getDayOfMonth() >= 21 && payment.getPaymentDate().getDayOfMonth() <= 26){
                payment.setPayedValue(payment.getPayedValue() * 0.60);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(31));
                return true;
            }
            return false;
        }
        //Dia dos pais
        if(payment.getSale().equals("PAIS85")){
            if(payment.getPaymentDate().getMonthValue() == 8 && payment.getPaymentDate().getDayOfMonth() == 28){
                payment.setPayedValue(payment.getPayedValue() * 0.85);
                return true;
            }
            return false;
        }
        //Dia das crianças
        if(payment.getSale().equals("CRIANCAS90")){
            if(payment.getPaymentDate().getMonthValue() == 10 && payment.getPaymentDate().getDayOfMonth() == 12){
                payment.setPayedValue(payment.getPayedValue() * 0.90);
                return true;
            }
            return false;
        }
        //Dia das maes
        if(payment.getSale().equals("MAES85")){
            if(payment.getPaymentDate().getMonthValue() == 5 && payment.getPaymentDate().getDayOfMonth() == 9){
                payment.setPayedValue(payment.getPayedValue() * 0.85);
                return true;
            }
            return false;
        }
        return false;
    }
}

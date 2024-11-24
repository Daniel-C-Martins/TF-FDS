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

   public PaymentModel registerPayment(PaymentModel payment) {
      return paymentRep.registerPayment(payment);
   }
}

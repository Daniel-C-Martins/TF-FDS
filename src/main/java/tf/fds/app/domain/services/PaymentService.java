package tf.fds.app.domain.services;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.repositories.IPaymentRepository;

public class PaymentService {
   private IPaymentRepository paymentRep;

   // @Autowired
   public PaymentService(IPaymentRepository paymentRep) {
      this.paymentRep = paymentRep;
   }

   PaymentModel registerPayment(PaymentModel payment, long codass) {
      return paymentRep.registerPayment(payment, codass);
   }
}

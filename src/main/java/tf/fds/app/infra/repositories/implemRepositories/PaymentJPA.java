package tf.fds.app.infra.repositories.implemRepositories;

import java.util.List;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.repositories.IPaymentRepository;
import tf.fds.app.infra.repositories.InterfJPA.Payment_ItfRep;

public class PaymentJPA implements IPaymentRepository{
    private Payment_ItfRep payment;

    public PaymentJPA(Payment_ItfRep payment) {
        this.payment = payment;
    }

    @Override
    public PaymentModel registerPayment(PaymentModel payment, long codass) {
        return;
    }
}

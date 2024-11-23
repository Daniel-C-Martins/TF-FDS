package tf.fds.app.infra.repositories.implemRepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.repositories.IPaymentRepository;
import tf.fds.app.infra.repositories.InterfJPA.Payment_ItfRep;
import tf.fds.app.infra.repositories.adapter.PaymentAdapter;

@Repository
public class PaymentJPA implements IPaymentRepository{
    private Payment_ItfRep payments;

    public PaymentJPA(Payment_ItfRep payments) {
        this.payments = payments;
    }

    @Override
    public PaymentModel registerPayment(PaymentModel payment) {
        payments.save(PaymentAdapter.fromPaymentModel(payment));
        return payment;
    }
}

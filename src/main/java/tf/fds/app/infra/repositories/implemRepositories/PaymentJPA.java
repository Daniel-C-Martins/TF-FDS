package tf.fds.app.infra.repositories.implemRepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.repositories.IPaymentRepository;
import tf.fds.app.infra.repositories.InterfJPA.Payment_ItfRep;
import tf.fds.app.infra.repositories.adapter.PaymentAdapter;

/**
 * Implementação da interface de repositório de pagamentos.
 */
@Repository
public class PaymentJPA implements IPaymentRepository {
    private Payment_ItfRep payments;

    /**
     * Constrói um novo PaymentJPA com o repositório especificado.
     * 
     * @param payments o repositório de pagamentos
     */
    public PaymentJPA(Payment_ItfRep payments) {
        this.payments = payments;
    }

    /**
     * Registra um pagamento.
     * 
     * @param payment o pagamento a ser registrado
     * @return o pagamento registrado
     */
    @Override
    public PaymentModel registerPayment(PaymentModel payment) {
        payments.save(PaymentAdapter.fromPaymentModel(payment));
        return payment;
    }
}

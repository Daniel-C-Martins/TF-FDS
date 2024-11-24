package tf.fds.app.domain.repositories;

import tf.fds.app.domain.entities.PaymentModel;

/**
 * Interface que representa o repositório de pagamentos.
 */
public interface IPaymentRepository {
    PaymentModel registerPayment(PaymentModel payment);
}

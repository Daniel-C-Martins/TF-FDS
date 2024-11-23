package tf.fds.app.domain.repositories;

import tf.fds.app.domain.entities.PaymentModel;

public interface IPaymentRepository {
    PaymentModel registerPayment(PaymentModel payment);
}

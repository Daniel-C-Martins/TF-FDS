package tf.fds.app.domain.repositories;

import tf.fds.app.domain.entity.PaymentModel;

public interface PaymentRepository {
    PaymentModel registerPayment(PaymentModel payment, long codass);
}

package tf.fds.app.domain.repositories;

import tf.fds.app.infra.repositories.entities.Payment;

public interface PaymentRepository {
    Payment registerPayment(Payment payment, long codass);
}

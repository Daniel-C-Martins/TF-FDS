package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entity.PaymentModel;
import tf.fds.app.infra.repositories.entities.Payment;

public class PaymentAdapter {
    
    public static Payment fromPaymentModel(PaymentModel pModel){
        return new Payment(pModel.getPayedValue(), pModel.getPaymentDate(), pModel.getSale(), null);
    }

    public static PaymentModel toPaymentModel(Payment pay){
        return new PaymentModel(pay.getCode(), pay.getPayedValue(), pay.getPaymentDate(), pay.getSale());
    }

}

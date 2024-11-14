package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entity.PaymentModel;
import tf.fds.app.infra.repositories.entities.Payment;

public class PaymentAdapter {
    
    public static Payment froPaymentModel(PaymentModel pModel){
        return new Payment(pModel.getPayedValue(), pModel.getPaymentDate(), pModel.getSale(), null);
    }
    //No último parametro Payment era para ter o GetSignature(), porem ele não reconhece 
    //De resto está tudo certo

    public static PaymentModel froPaymentModel(Payment pay){
        return new PaymentModel(pay.getCode(), pay.getPayedValue(), pay.getPaymentDate(), pay.getSale());
    }

}

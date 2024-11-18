package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.infra.repositories.entities.Payment;

public class PaymentAdapter {

    /*
     * Conversor de PaymentModel para Payment
     * @param pModel
     * @return Payment
     * Cria um objeto Payment a partir de um objeto PaymentModel
     * Mapea os objetos de PaymentModel para Payment
     */
    public static Payment fromPaymentModel(PaymentModel pModel){
        Payment pay = new Payment(pModel.getPayedValue(), pModel.getPaymentDate(), pModel.getSale(), SignatureAdapter.fromSignatureModel(pModel.getSignature()));
        pay.setCode(pModel.getCode());
        return pay;
    }

    /*
     * Conversor de Payment para PaymentModel
     * @param pay
     * @return PaymentModel
     * Cria um objeto PaymentModel a partir de um objeto Payment
     * Mapea os objetos de Payment para PaymentModel
     */
    public static PaymentModel toPaymentModel(Payment pay){
        PaymentModel pModel= new PaymentModel(pay.getCode(), pay.getPayedValue(), pay.getPaymentDate(), pay.getSale(), SignatureAdapter.toSignatureModel(pay.getSignature()));
        pModel.setCode(pay.getCode());
        return pModel;
    }
}

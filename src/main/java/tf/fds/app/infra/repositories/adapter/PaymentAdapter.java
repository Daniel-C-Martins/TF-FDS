package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.infra.repositories.entities.Payment;

public class PaymentAdapter {

    /**
     * Conversor de PaymentModel para Payment
     * 
     * @param pModel
     * @return Payment
     *         Cria um objeto Payment a partir de um objeto PaymentModel
     *         Mapea os objetos de PaymentModel para Payment
     */
    public static Payment fromPaymentModel(PaymentModel pModel) {
        Payment pay = new Payment();
        pay.setCode(pModel.getCode());
        pay.setPayedValue(pModel.getPayedValue());
        pay.setPaymentDate(pModel.getPaymentDate());
        pay.setSale(pModel.getSale());
        pay.setStatus(pModel.getStatus());
        pay.setSignature(SignatureAdapter.fromSignatureModel(pModel.getSignature()));
        pay.setReturnedValue(pModel.getReturnedValue());
        return pay;
    }

    /**
     * Conversor de Payment para PaymentModel
     * 
     * @param pay
     * @return PaymentModel
     *         Cria um objeto PaymentModel a partir de um objeto Payment
     *         Mapea os objetos de Payment para PaymentModel
     */
    public static PaymentModel toPaymentModel(Payment pay) {
        PaymentModel pModel = new PaymentModel();
        pModel.setCode(pay.getCode());
        pModel.setPayedValue(pay.getPayedValue());
        pModel.setPaymentDate(pay.getPaymentDate());
        pModel.setSale(pay.getSale());
        pModel.setStatus(pay.getStatus());
        pModel.setSignature(SignatureAdapter.toSignatureModel(pay.getSignature()));
        pModel.setReturnedValue(pay.getReturnedValue());
        return pModel;
    }
}

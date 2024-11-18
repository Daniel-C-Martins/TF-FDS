package tf.fds.app.infra.repositories.adapter;

import java.util.LinkedList;
import java.util.List;

import tf.fds.app.infra.repositories.entities.Signature;
import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.infra.repositories.entities.Payment;

public class SignatureAdapter {

    /*
     * Conversor de SignatureModel para Signature
     * @param sModel
     * @return Signature
     * Cria um objeto Signature a partir de um objeto SignatureModel
     * Mapea os objetos de SignatureModel para Signature
     * Usa setCode para definir o código do objeto Signature
     * Cria uma lista de payments a partir da lista de paymentModel de SignatureModel
     * Usa setPayments para definir a lista de pagamentos do objeto Signature
     */
    public static Signature fromSignatureModel (SignatureModel sModel){
        Signature sign =  new Signature(sModel.getBeginningDate(), sModel.getEndDate(), ClientAdapter.fromClientModel(sModel.getClient()), ApplicativeAdapter.fromApplicativeModel(sModel.getApplicative()));
        sign.setCode(sModel.getCode());
        List<Payment> pay = new LinkedList<Payment>();
        sModel.getPayments().stream().forEach(p -> pay.add(PaymentAdapter.fromPaymentModel(p)));
        sign.setPayments(pay);
        return sign;
    }

    /*
     * Conversor de Signature para SignatureModel
     * @param sign
     * @return SignatureModel
     * Cria um objeto SignatureModel a partir de um objeto Signature
     * Mapea os objetos de Signature para SignatureModel
     * Usa setCode para definir o código do objeto SignatureModel
     * Cria uma lista de payments a partir da lista de payment de Signature
     * Usa setPayments para definir a lista de pagamentos do objeto SignatureModel
     */
    public static SignatureModel toSignatureModel (Signature sign){
        SignatureModel sModel = new SignatureModel(sign.getCode(), sign.getBeginningDate(), sign.getEndDate(), ClientAdapter.toClientModel(sign.getClient()), ApplicativeAdapter.toApplicativeModel(sign.getApplicative()));
        List<PaymentModel> pay = new LinkedList<PaymentModel>();
        sign.getPayments().stream().forEach(p -> pay.add(PaymentAdapter.toPaymentModel(p)));
        sModel.setPayments(pay);
        return sModel;
    }
}

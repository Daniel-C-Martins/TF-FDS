package tf.fds.app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.repositories.IPaymentRepository;

/**
 * Classe de serviço para pagamentos.
 */
@Service
public class PaymentService {
    private IPaymentRepository paymentRep;

    @Autowired
    public PaymentService(IPaymentRepository paymentRep) {
        this.paymentRep = paymentRep;
    }

    public PaymentModel registerPayment(PaymentModel payment) {
        applyPromotion(payment);
        return paymentRep.registerPayment(payment);
    }

    private void applyPromotion(PaymentModel payment) {
        if (payment.getSale().equals("none")) {
            payment.setReturnedValue(
                    payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
        }
        // Promoção de Black Friday
        else if (payment.getSale().equals("BLK50")) {
            if (payment.getPaymentDate().getMonthValue() == 11 && payment.getPaymentDate().getDayOfMonth() >= 21) {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost() * 0.5);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(30));
            } else {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
            }
        }

        // Promoção de Natal
        else if (payment.getSale().equals("NATAL65")) {
            if (payment.getPaymentDate().getMonthValue() == 12 && payment.getPaymentDate().getDayOfMonth() <= 25) {
                payment.setReturnedValue((payment.getSignature().getApplicative().getMonthlyCost() * 12) * 0.65);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusYears(1));
            } else {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
            }
        }
        // Promoção de Ano Novo
        else if (payment.getSale().equals("ANO75")) {
            if (payment.getPaymentDate().getMonthValue() == 1 && payment.getPaymentDate().getDayOfMonth() >= 1
                    && payment.getPaymentDate().getDayOfMonth() <= 29) {
                payment.setReturnedValue((payment.getSignature().getApplicative().getMonthlyCost() * 0.75));
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(35));
            } else {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
            }
        }
        // Promoção de Carnaval
        else if (payment.getSale().equals("CARNAVAL60")) {
            if (payment.getPaymentDate().getMonthValue() == 2 && payment.getPaymentDate().getDayOfMonth() >= 21
                    && payment.getPaymentDate().getDayOfMonth() <= 26) {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost() * 0.6);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(30));
            } else {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
            }

        }
        // Promoção de dia dos pais
        else if (payment.getSale().equals("PAIS85")) {
            if (payment.getPaymentDate().getMonthValue() == 8 && payment.getPaymentDate().getDayOfMonth() == 28) {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost() * 0.85);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(30));
            } else {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
            }
        }
        // Promoção de dia das crianças
        else if (payment.getSale().equals("CRIANCAS90")) {
            if (payment.getPaymentDate().getMonthValue() == 10 && payment.getPaymentDate().getDayOfMonth() == 12) {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost() * 0.90);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(30));
            } else {
                payment.setReturnedValue(
                    payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
            }
        }
        // Promoção de dia das mães
        else if (payment.getSale().equals("MAES85")) {
            if (payment.getPaymentDate().getMonthValue() == 5 && payment.getPaymentDate().getDayOfMonth() == 9) {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost() * 0.85);
                payment.getSignature().setEndDate(payment.getSignature().getEndDate().plusDays(30));
            } else {
                payment.setReturnedValue(
                        payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
            }
        }
    }
}

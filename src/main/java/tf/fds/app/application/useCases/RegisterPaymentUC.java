package tf.fds.app.application.useCases;

import java.time.LocalDate;

import tf.fds.app.application.responseDTO.PaymentDTO;
import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.domain.services.PaymentService;
import tf.fds.app.domain.services.SignatureService;
import tf.fds.app.infra.Enums.PaymentStatus.PaymentStatuses;

/**
 * Caso de uso para registrar umpayment.
 */
public class RegisterPaymentUC {

   /**
    * Serviço para lidar com operações de pagamento.
    */
   private PaymentService paymentService;

   /**
    * Serviço para lidar com operações de assinatura.
    */
   private SignatureService signatureService;

   /**
    * Constrói um novo RegisterPaymentUC com os serviços de pagamento e assinatura
    * especificados.
    *
    * @param paymentService   o serviço de pagamento a ser usado
    * @param signatureService o serviço de assinatura a ser usado
    */
   public RegisterPaymentUC(PaymentService paymentService, SignatureService signatureService) {
      this.paymentService = paymentService;
      this.signatureService = signatureService;
   }

   /**
    * Registra um pagamento com os detalhes fornecidos.
    *
    * @param day           o day da data de pagamento
    * @param month         o mês da data de pagamento
    * @param year          o year da data de pagamento
    * @param signatureCode o código da assinatura associada ao pagamento
    * @param value         o valor do pagamento
    * @return um PaymentDTO contendo os detalhes do pagamento registrado
    * @throws IllegalArgumentException se a assinatura não for encontrada
    */
   public PaymentDTO run(int day, int month, int year, long signatureCode, double value) {
      PaymentModel payment = new PaymentModel();
      LocalDate data = LocalDate.of(year, month, day);
      payment.setPaymentDate(data);
      payment.setSignature(signatureService.getSignatureById(signatureCode));
      payment.setSale("Venda");
      payment.setPayedValue(value);

      if (payment.getPayedValue() < payment.getSignature().getApplicative().getMonthlyCost()) {
         payment.setStatus(PaymentStatuses.INCORRECT_VALUE);

         PaymentDTO payDTO = new PaymentDTO(payment);
         payDTO.setReturnedValue(payment.getPayedValue());
         return payDTO;
      } else {
         payment.setStatus(PaymentStatuses.OK);
         PaymentDTO payDTO = new PaymentDTO(paymentService.registerPayment(payment));
         payDTO.setReturnedValue(payment.getPayedValue() - payment.getSignature().getApplicative().getMonthlyCost());
         LocalDate endDate = signatureService.getSignatureById(signatureCode).getEndDate();
         signatureService.getSignatureById(signatureCode).setEndDate(endDate.plusDays(30));
         return payDTO;
      }
   }
}
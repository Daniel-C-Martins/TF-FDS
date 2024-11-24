package tf.fds.app.application.useCases;

import org.springframework.stereotype.Component;

import tf.fds.app.domain.services.SignatureService;

@Component
public class ValidSignatureUC {
   private SignatureService signatureService;

   public ValidSignatureUC(SignatureService signatureService) {
      this.signatureService = signatureService;
   }

   public boolean run(long codass) {
      if (signatureService.getSignatureById(codass) == null) {
         throw new IllegalArgumentException("Assinatura não encontrada");
      }
      return signatureService.isActive(codass);
   }
}

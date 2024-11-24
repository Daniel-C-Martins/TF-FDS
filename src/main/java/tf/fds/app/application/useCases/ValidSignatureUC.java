package tf.fds.app.application.useCases;

import org.springframework.stereotype.Component;
import tf.fds.app.domain.services.SignatureService;

/**
 * Componente que representa o caso de uso para verificar se uma assinatura é
 * válida.
 */
@Component
public class ValidSignatureUC {
   private SignatureService signatureService;

   /**
    * Constrói um novo ValidSignatureUC com o serviço especificado.
    * 
    * @param signatureService o serviço para lidar com operações de assinatura
    */
   public ValidSignatureUC(SignatureService signatureService) {
      this.signatureService = signatureService;
   }

   /**
    * Executa o caso de uso para verificar se uma assinatura é válida.
    * 
    * @param codass
    * @return
    */
   public boolean run(long codass) {

      // Verifica se a assinatura existe
      if (signatureService.getSignatureById(codass) == null) {
         throw new IllegalArgumentException("Assinatura não encontrada");
      }

      // Verifica se a assinatura está ativa
      return signatureService.isActive(codass);
   }
}

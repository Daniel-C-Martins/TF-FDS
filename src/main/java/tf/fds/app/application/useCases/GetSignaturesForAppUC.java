package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.domain.services.ApplicativeService;
import tf.fds.app.domain.services.SignatureService;

/**
 * Componente que representa o caso de uso para obter todas as assinaturas de um
 * aplicativo.
 */
@Component
public class GetSignaturesForAppUC {

   private SignatureService signatureService;
   private ApplicativeService applicativeService;

   /**
    * Constrói um novo GetSignaturesForAppUC com os serviços especificados.
    * 
    * @param signatureService   o serviço para lidar com operações de assinatura
    * @param applicativeService o serviço para lidar com operações de aplicativo
    */
   @Autowired
   public GetSignaturesForAppUC(SignatureService signatureService, ApplicativeService applicativeService) {
      this.signatureService = signatureService;
      this.applicativeService = applicativeService;
   }

   /**
    * Executa o caso de uso para obter todas as assinaturas de um aplicativo.
    * 
    * @param codapp o ID do aplicativo
    * @return uma lista de SignatureDTO contendo os detalhes de todas as
    *         assinaturas do aplicativo
    * @throws IllegalArgumentException se o aplicativo não for encontrado
    */
   public List<SignatureDTO> run(long codapp) {
      if (applicativeService.getApplicativeById(codapp) == null) {
         throw new IllegalArgumentException("Aplicativo não encontrado");
      }

      // Atualiza o status das assinaturas
      signatureService.updateSignatureStatus();

      // Retorna todas as assinaturas do aplicativo
      return signatureService.getSignaturesByApp(codapp).stream().map(signature -> new SignatureDTO(signature))
            .toList();
   }
}

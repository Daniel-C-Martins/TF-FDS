package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.domain.Enums.SignatureType.SignatureTypes;
import tf.fds.app.domain.services.SignatureService;

/**
 * Componente que representa o caso de uso para obter todas as assinaturas de um
 * aplicativo.
 */
@Component
public class GetSignatureTypes {
   private SignatureService signatureService;

   /**
    * Constrói um novo GetSignaturesForAppUC com os serviços especificados.
    * 
    * @param signatureService o serviço para lidar com operações de assinatura
    */
   public GetSignatureTypes(SignatureService signatureService) {
      this.signatureService = signatureService;
   }

   /**
    * Executa o caso de uso para obter todas as assinaturas de um aplicativo.
    * 
    * @param type o tipo de assinatura
    * @return uma lista de SignatureDTO contendo os detalhes de todas as
    *         assinaturas do aplicativo
    * @throws IllegalArgumentException se o tipo de assinatura não for encontrado
    */
   public List<SignatureDTO> run(String type) {

      // atualiza o status das assinaturas
      signatureService.updateSignatureStatus();

      // testa o tipo da assinatura
      if (type.equals("ALL"))
         // retorna todas as assinaturas
         return signatureService.getAllSignatures().stream().map(signature -> new SignatureDTO(signature)).toList();

      if (type.equals("ACTIVE")) {
         // retorna todas as assinaturas ativas
         return signatureService.getAllSignatures().stream()
               .filter(s -> s.getType() == SignatureTypes.ACTIVE)
               .map(signature -> new SignatureDTO(signature)).toList();
      }

      if (type.equals("CANCELED")) {
         // retorna todas as assinaturas canceladas
         return signatureService.getAllSignatures().stream()
               .filter(s -> s.getType() == SignatureTypes.CANCELED)
               .map(signature -> new SignatureDTO(signature)).toList();
      }
      throw new IllegalArgumentException("Tipo de assinatura inválido");
   }
}

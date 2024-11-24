package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.domain.services.ClientService;
import tf.fds.app.domain.services.SignatureService;

/**
 * Componente que representa o caso de uso para obter todas as assinaturas de um
 * cliente.
 */
@Component
public class GetSignaturesForClientUC {
   private SignatureService signatureService;
   private ClientService clientService;

   /**
    * Constrói um novo GetSignaturesForClientUC com os serviços especificados.
    * 
    * @param signatureService o serviço para lidar com operações de assinatura
    * @param clientService    o serviço para lidar com operações de cliente
    */
   public GetSignaturesForClientUC(SignatureService signatureService, ClientService clientService) {
      this.signatureService = signatureService;
      this.clientService = clientService;
   }

   /**
    * Executa o caso de uso para obter todas as assinaturas de um cliente.
    * 
    * @param clientId o ID do cliente
    * @return uma lista de SignatureDTO contendo os detalhes de todas
    */
   public List<SignatureDTO> run(Long clientId) {

      // Verifica se o cliente existe
      if (clientService.getClientById(clientId) == null) {
         throw new IllegalArgumentException("Cliente não encontrado");
      }

      // Atualiza o status das assinaturas
      signatureService.updateSignatureStatus();

      // Retorna todas as assinaturas do cliente
      return signatureService.getSignaturesByClient(clientId).stream().map(signature -> new SignatureDTO(signature))
            .toList();
   }
}
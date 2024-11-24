package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.domain.services.ClientService;
import tf.fds.app.domain.services.SignatureService;

@Component
public class GetSignaturesForClientUC {
   private SignatureService signatureService;
   private ClientService clientService;

   public GetSignaturesForClientUC(SignatureService signatureService, ClientService clientService) {
      this.signatureService = signatureService;
      this.clientService = clientService;
   }

   public List<SignatureDTO> run(Long clientId) {
      if (clientService.getClientById(clientId) == null) {
         throw new IllegalArgumentException("Cliente não encontrado");
      }
      return signatureService.getSignaturesByClient(clientId).stream().map(signature -> new SignatureDTO(signature))
            .toList();
   }
}
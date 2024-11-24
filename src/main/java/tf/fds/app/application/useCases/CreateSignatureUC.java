package tf.fds.app.application.useCases;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.domain.Enums.SignatureType.SignatureTypes;
import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.domain.services.ApplicativeService;
import tf.fds.app.domain.services.ClientService;
import tf.fds.app.domain.services.SignatureService;

/**
 * Caso de uso para criar uma nova assinatura.
 * Esta classe é responsável por lidar com a criação de uma nova assinatura, validando o cliente e o aplicativo,
 * e então criando uma nova assinatura com os detalhes fornecidos.
 */
@Component
public class CreateSignatureUC {

   private final SignatureService signatureService;
   private final ClientService clientService;
   private final ApplicativeService applicativeService;

   /**
    * Constrói um novo CreateSignatureUC com os serviços especificados.
    *
    * @param signatureService o serviço para lidar com operações de assinatura
    * @param clientService o serviço para lidar com operações de cliente
    * @param applicativeService o serviço para lidar com operações de aplicativo
    */
   public CreateSignatureUC(SignatureService signatureService, ClientService clientService, ApplicativeService applicativeService) {
      this.signatureService = signatureService;
      this.clientService = clientService;
      this.applicativeService = applicativeService;
   }

   /**
    * Executa o caso de uso para criar uma nova assinatura.
    *
    * @param clienteId o ID do cliente
    * @param applicativeId o ID do aplicativo
    * @return um SignatureDTO contendo os detalhes da assinatura criada
    * @throws IllegalArgumentException se o cliente ou aplicativo não for encontrado
    */
   public SignatureDTO run(long clienteId, long applicativeId) {

      // Verifica se o cliente e o aplicativo existem
      if (clientService.getClientById(clienteId) == null) {
         throw new IllegalArgumentException("Cliente não encontrado");
      }

      if (applicativeService.getApplicativeById(applicativeId) == null){
         throw new IllegalArgumentException("Aplicativo não encontrado");
      }

      // Cria uma nova assinatura com os detalhes fornecidos
      SignatureModel signModel = new SignatureModel();
      signModel.setClient(clientService.getClientById(clienteId));
      signModel.setApplicative(applicativeService.getApplicativeById(applicativeId));
      signModel.setBeginningDate(LocalDate.now());

      // Define a data de término da assinatura como 30 dias a partir da data de início
      signModel.setEndDate(LocalDate.now().plusDays(30));

      // Define o tipo da assinatura como ativa
      signModel.setType(SignatureTypes.ACTIVE);

      return new SignatureDTO(signatureService.createSignature(signModel));
   }
}

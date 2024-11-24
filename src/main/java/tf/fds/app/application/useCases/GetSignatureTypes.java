package tf.fds.app.application.useCases;

import java.time.LocalDate;
import java.util.List;

import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.domain.services.SignatureService;

public class GetSignatureTypes {
   private SignatureService signatureService;

   public GetSignatureTypes(SignatureService signatureService) {
      this.signatureService = signatureService;
   }

   public List<SignatureDTO> run(String type) {

      signatureService.getAllSignatures().stream()
            .filter(s -> s.getEndDate().isAfter(LocalDate.now()))
            .forEach(s -> s.setType(SignatureModel.SignatureTypes.ACTIVE));

      signatureService.getAllSignatures().stream().filter(s -> s.getEndDate().isBefore(LocalDate.now()))
            .forEach(s -> s.setType(SignatureModel.SignatureTypes.CANCELED));

      if (type.equals("ALL"))
         return signatureService.getAllSignatures().stream().map(signature -> new SignatureDTO(signature)).toList();

      if (type.equals("ACTIVE")) {
         return signatureService.getAllSignatures().stream()
               .filter(s -> s.getType() == SignatureModel.SignatureTypes.ACTIVE)
               .map(signature -> new SignatureDTO(signature)).toList();
      }

      if (type.equals("CANCELED")) {
         return signatureService.getAllSignatures().stream()
               .filter(s -> s.getType() == SignatureModel.SignatureTypes.CANCELED)
               .map(signature -> new SignatureDTO(signature)).toList();
      }

      throw new IllegalArgumentException("Tipo de assinatura inválido");
   }
}

package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.domain.services.ApplicativeService;
import tf.fds.app.domain.services.SignatureService;

@Component
public class GetSignaturesForAppUC {
   private SignatureService signatureService;
   private ApplicativeService applicativeService;

   @Autowired
   public GetSignaturesForAppUC(SignatureService signatureService, ApplicativeService applicativeService) {
      this.signatureService = signatureService;
      this.applicativeService = applicativeService;
   }

   public List<SignatureDTO> run(long codapp) {
      if (applicativeService.getApplicativeById(codapp) == null) {
         throw new IllegalArgumentException("Aplicativo não encontrado");
      }
      return signatureService.getSignaturesByApp(codapp).stream().map(signature -> new SignatureDTO(signature)).toList();
   }
}

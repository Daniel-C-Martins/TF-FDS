package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.ApplicativeDTO;
import tf.fds.app.domain.services.ApplicativeService;

@Component
public class GetAllApplicativesUC {
   private ApplicativeService applicativeSerive;

   public GetAllApplicativesUC(ApplicativeService applicativeSerive) {
      this.applicativeSerive = applicativeSerive;
   }

   public List<ApplicativeDTO> run() {
      return applicativeSerive.getAllApplicatives().stream().map(applicative -> new ApplicativeDTO(applicative)).toList();
   }
}

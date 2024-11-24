package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.ApplicativeDTO;
import tf.fds.app.domain.services.ApplicativeService;

/*
 * Caso de uso para pegar todas os aplicativos.
 * Esta classe é responsável por obter todos os aplicativos.	
 */
@Component
public class GetAllApplicativesUC {
   private ApplicativeService applicativeSerive;

   /**
    * Constrói um novo GetAllApplicativesUC com o serviço especificado.
    * 
    * @param applicativeSerive o serviço para lidar com operações de aplicativo
    */
   public GetAllApplicativesUC(ApplicativeService applicativeSerive) {
      this.applicativeSerive = applicativeSerive;
   }

   /**
    * Executa o caso de uso para obter todos os aplicativos.
    *
    * @return uma lista de ApplicativeDTO contendo os detalhes de todos os
    *         aplicativos
    */
   public List<ApplicativeDTO> run() {
      return applicativeSerive.getAllApplicatives().stream().map(applicative -> new ApplicativeDTO(applicative))
            .toList();
   }
}

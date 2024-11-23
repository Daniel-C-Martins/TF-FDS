package tf.fds.app.application.useCases;

import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.ApplicativeDTO;
import tf.fds.app.domain.services.ApplicativeService;

/**
 * UpdateCost é uma classe de caso de uso responsável por atualizar o custo mensal de um aplicativo.
 * Ela usa o ApplicativeService para realizar a operação de atualização.
 * 
 * @component Indica que esta classe é um componente Spring.
 */
@Component
public class UpdateCostUC {
   private ApplicativeService applicativeService;

   /**
    * Construtor da classe UpdateCost.
    * 
    * @param applicativeService O serviço de aplicativos usado para realizar a operação de atualização.
    */
   public UpdateCostUC(ApplicativeService applicativeService){
      this.applicativeService = applicativeService;
   }

   /**
    * Executa a operação de atualização do custo mensal de um aplicativo.
    * 
    * @param newCost O novo custo mensal do aplicativo.
    * @param id O ID do aplicativo a ser atualizado.
    * @return Um DTO do aplicativo atualizado.
    * @throws IllegalArgumentException Se o aplicativo não existir ou se o novo custo for inválido.
    */
   public ApplicativeDTO run(double newCost, Long id){
      if (applicativeService.getApplicativeById(id) == null){
         throw new IllegalArgumentException("Aplicativo inexistente");
      }
      if (newCost < 0){
         throw new IllegalArgumentException("Custo mensal inválido");
      }
      applicativeService.updateMonthlyCost(newCost, id);
      return new ApplicativeDTO(applicativeService.getApplicativeById(id));
   }
}

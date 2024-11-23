package tf.fds.app.infra.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tf.fds.app.application.requestDTO.RequestSignDTO;
import tf.fds.app.application.responseDTO.ApplicativeDTO;
import tf.fds.app.application.responseDTO.ClientDTO;
import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.application.useCases.CreateSignatureUC;
import tf.fds.app.application.useCases.GetAllClientsUC;

@RestController
public class Controller {
    private GetAllClientsUC getAllClients;
    private CreateSignatureUC createSignature;

    public Controller (GetAllClientsUC getAllClients, CreateSignatureUC createSignature){
        this.getAllClients = getAllClients;
        this.createSignature = createSignature;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String home(){
        return "Welcome to your app home!";
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClientDTO> getAllClients(){
        return getAllClients.run();
    }  

    // @GetMapping("/servcad/aplicativos")
    // @CrossOrigin(origins = "*")
    // public List<ApplicativeDTO> getAllApplicatives(){
    //     //TODO
    // }

    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public SignatureDTO createSignature(@RequestBody RequestSignDTO signature){
        return createSignature.run(signature.getClientCode(), signature.getApplicativeCode());
    }

    // @PostMapping("/servcad/aplicativos/atualizacusto/:idAplicativo")
    // @CrossOrigin(origins = "*")
    // public ApplicativeDTO updateApplicativeCost(@PathVariable long applicativeId, @RequestBody double cost){
    //     //TODO
    // }

    // @GetMapping("/servcad/assinaturas/{tipo}")
    // @CrossOrigin(origins = "*")
    // public List<SignatureDTO> getSubscriptionsForTypes(@PathVariable String type){
    //     //TODO
    // }

    // @GetMapping("/servcad/asscli/:codcli")
    // @CrossOrigin(origins = "*")
    // public List<SignatureDTO> getSubscriptionsForClient(@PathVariable long clientId){
    //     //TODO
    // }

    // @GetMapping("/servcad/assapp/:codapp")
    // @CrossOrigin(origins = "*")
    // public List<SignatureDTO> getSubscriptionsForApplicative(@PathVariable long applicativeId){
    //     //TODO
    // }

    // @PostMapping("/registrarpagamento")
    // @CrossOrigin(origins = "*")
    // public void registerPayment(@RequestBody int day, int month, int year, long signatureCode, double value){
    //     //TODO
    //     // Retorna status, data, valor estornado
    //     // Status sendo PAGAMENTO_OK, VALOR_INCORRETO
    // }

    // @GetMapping("/assinvalida/:codass")
    // @CrossOrigin(origins = "*")
    // public boolean isSubscriptionValid(@PathVariable long signatureCode){
    //     //TODO
    // }
}

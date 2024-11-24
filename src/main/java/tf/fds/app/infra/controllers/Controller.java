package tf.fds.app.infra.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tf.fds.app.application.requestDTO.RequestCostDTO;
import tf.fds.app.application.requestDTO.RequestSignDTO;
import tf.fds.app.application.responseDTO.ApplicativeDTO;
import tf.fds.app.application.responseDTO.ClientDTO;
import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.application.useCases.CreateSignatureUC;
import tf.fds.app.application.useCases.GetAllApplicativesUC;
import tf.fds.app.application.useCases.GetAllClientsUC;
import tf.fds.app.application.useCases.GetSignatureTypes;
import tf.fds.app.application.useCases.GetSignaturesForAppUC;
import tf.fds.app.application.useCases.GetSignaturesForClientUC;
import tf.fds.app.application.useCases.UpdateCostUC;
import tf.fds.app.application.useCases.ValidSignatureUC;

@RestController
public class Controller {
    private GetAllClientsUC getAllClients;
    private CreateSignatureUC createSignature;
    private UpdateCostUC updateCost;
    private GetSignaturesForClientUC getSignaturesForClient;
    private GetAllApplicativesUC getAllApplicatives;
    private GetSignaturesForAppUC getSignaturesForApp;
    private ValidSignatureUC validSignature;
    private GetSignatureTypes getSignatureTypes;

    public Controller(GetAllClientsUC getAllClients, CreateSignatureUC createSignature, UpdateCostUC updateCost,
            GetSignaturesForClientUC getSignaturesForClient, GetAllApplicativesUC getAllApplicatives,
            GetSignaturesForAppUC getSignaturesForApp, ValidSignatureUC validSignature, GetSignatureTypes getSignatureTypes) {
        this.getAllClients = getAllClients;
        this.createSignature = createSignature;
        this.updateCost = updateCost;
        this.getSignaturesForClient = getSignaturesForClient;
        this.getAllApplicatives = getAllApplicatives;
        this.getSignaturesForApp = getSignaturesForApp;
        this.validSignature = validSignature;
        this.getSignatureTypes = getSignatureTypes;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String home() {
        return "Welcome to your app home!";
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClientDTO> getAllClients() {
        return getAllClients.run();
    }

    @GetMapping("/servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<ApplicativeDTO> getAllApplicatives() {
        return getAllApplicatives.run();
    }

    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public SignatureDTO createSignature(@RequestBody RequestSignDTO signature) {
        return createSignature.run(signature.getClientCode(), signature.getApplicativeCode());
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{applicativeId}")
    @CrossOrigin(origins = "*")
    public ApplicativeDTO updateApplicativeCost(@PathVariable long applicativeId, @RequestBody RequestCostDTO cost) {
        return updateCost.run(cost.getNewCost(), applicativeId);
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<SignatureDTO> getSubscriptionsForTypes(@PathVariable String
    type){
        return getSignatureTypes.run(type);
    }

    @GetMapping("/servcad/asscli/{clientId}")
    @CrossOrigin(origins = "*")
    public List<SignatureDTO> getSignaturesForClient(@PathVariable long clientId) {
        return getSignaturesForClient.run(clientId);
    }

    @GetMapping("/servcad/assapp/{applicativeId}")
    @CrossOrigin(origins = "*")
    public List<SignatureDTO> getSignaturesForApplicative(@PathVariable long applicativeId) {
        return getSignaturesForApp.run(applicativeId);
    }

    // @PostMapping("/registrarpagamento")
    // @CrossOrigin(origins = "*")
    // public void registerPayment(@RequestBody int day, int month, int year, long
    // signatureCode, double value){
    // //TODO
    // // Retorna status, data, valor estornado
    // // Status sendo PAGAMENTO_OK, VALOR_INCORRETO
    // }

    @GetMapping("/assinvalida/{signatureCode}")
    @CrossOrigin(origins = "*")
    public boolean isSignatureValid(@PathVariable long signatureCode) {
        return validSignature.run(signatureCode);
    }
}

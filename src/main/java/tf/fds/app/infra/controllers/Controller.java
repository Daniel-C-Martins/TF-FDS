package tf.fds.app.infra.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tf.fds.app.application.requestDTO.RequestCostDTO;
import tf.fds.app.application.requestDTO.RequestPayDTO;
import tf.fds.app.application.requestDTO.RequestSignDTO;
import tf.fds.app.application.responseDTO.ApplicativeDTO;
import tf.fds.app.application.responseDTO.ClientDTO;
import tf.fds.app.application.responseDTO.PaymentDTO;
import tf.fds.app.application.responseDTO.SignatureDTO;
import tf.fds.app.application.useCases.CreateSignatureUC;
import tf.fds.app.application.useCases.GetAllApplicativesUC;
import tf.fds.app.application.useCases.GetAllClientsUC;
import tf.fds.app.application.useCases.GetSignatureTypes;
import tf.fds.app.application.useCases.GetSignaturesForAppUC;
import tf.fds.app.application.useCases.GetSignaturesForClientUC;
import tf.fds.app.application.useCases.RegisterPaymentUC;
import tf.fds.app.application.useCases.UpdateCostUC;
import tf.fds.app.application.useCases.ValidSignatureUC;

/**
 * Classe controladora para a aplicação.
 */
@RestController
public class Controller {
    private GetAllClientsUC getAllClients;
    private CreateSignatureUC createSignature;
    private UpdateCostUC updateCost;
    private GetSignaturesForClientUC getSignaturesForClient;
    private GetAllApplicativesUC getAllApplicatives;
    private GetSignaturesForAppUC getSignaturesForApp;
    private ValidSignatureUC validSignature;
    private RegisterPaymentUC registerPayment;
    private GetSignatureTypes getSignatureTypes;

    /**
     * Constrói um novo Controller com os casos de uso especificados.
     * 
     * @param getAllClients
     * @param createSignature
     * @param updateCost
     * @param getSignaturesForClient
     * @param getAllApplicatives
     * @param getSignaturesForApp
     * @param validSignature
     * @param getSignatureTypes
     * @param registerPayment
     */
    public Controller(GetAllClientsUC getAllClients, CreateSignatureUC createSignature, UpdateCostUC updateCost,
            GetSignaturesForClientUC getSignaturesForClient, GetAllApplicativesUC getAllApplicatives,
            GetSignaturesForAppUC getSignaturesForApp, ValidSignatureUC validSignature,
            GetSignatureTypes getSignatureTypes, RegisterPaymentUC registerPayment) {
        this.getAllClients = getAllClients;
        this.createSignature = createSignature;
        this.updateCost = updateCost;
        this.getSignaturesForClient = getSignaturesForClient;
        this.getAllApplicatives = getAllApplicatives;
        this.getSignaturesForApp = getSignaturesForApp;
        this.validSignature = validSignature;
        this.getSignatureTypes = getSignatureTypes;
        this.registerPayment = registerPayment;
    }

    /**
     * Retorna a mensagem de boas-vindas da aplicação.
     * 
     * @return a mensagem de boas-vindas
     */
    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String home() {
        return "Welcome to your app home!";
    }

    /**
     * Retorna todos os clientes.
     * 
     * @return uma lista de ClientDTO contendo os detalhes de todos os clientes
     */
    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClientDTO> getAllClients() {
        return getAllClients.run();
    }

    /**
     * Retorna todos os aplicativos.
     * 
     * @return uma lista de ApplicativeDTO contendo os detalhes de todos os
     *         aplicativos
     */
    @GetMapping("/servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<ApplicativeDTO> getAllApplicatives() {
        return getAllApplicatives.run();
    }

    /**
     * Cria uma nova assinatura.
     * 
     * @param signature
     * @return SignatureDTO contendo os detalhes da assinatura criada
     */
    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public SignatureDTO createSignature(@RequestBody RequestSignDTO signature) {
        return createSignature.run(signature.getClientCode(), signature.getApplicativeCode());
    }

    /**
     * Retorna todas as assinaturas de um cliente.
     * 
     * @param applicativeId
     * @param cost
     * @return ApplicativeDTO contendo os detalhes do aplicativo atualizado
     */
    @PostMapping("/servcad/aplicativos/atualizacusto/{applicativeId}")
    @CrossOrigin(origins = "*")
    public ApplicativeDTO updateApplicativeCost(@PathVariable long applicativeId, @RequestBody RequestCostDTO cost) {
        return updateCost.run(cost.getNewCost(), applicativeId);
    }

    /**
     * Retorna todas as assinaturas de um cliente.
     * 
     * @param clientId
     * @return uma lista de SignatureDTO contendo os detalhes de todas as
     *         assinaturas do cliente
     */
    @GetMapping("/servcad/assinaturas/{type}")
    @CrossOrigin(origins = "*")
    public List<SignatureDTO> getSubscriptionsForTypes(@PathVariable String type) {
        return getSignatureTypes.run(type);
    }

    /**
     * Retorna todas as assinaturas de um cliente.
     * 
     * @param clientId
     * @return uma lista de SignatureDTO contendo os detalhes de todas as
     *         assinaturas do cliente
     */
    @GetMapping("/servcad/asscli/{clientId}")
    @CrossOrigin(origins = "*")
    public List<SignatureDTO> getSignaturesForClient(@PathVariable long clientId) {
        return getSignaturesForClient.run(clientId);
    }

    /**
     * Retorna todas as assinaturas de um aplicativo.
     * 
     * @param applicativeId
     * @return
     */
    @GetMapping("/servcad/assapp/{applicativeId}")
    @CrossOrigin(origins = "*")
    public List<SignatureDTO> getSignaturesForApplicative(@PathVariable long applicativeId) {
        return getSignaturesForApp.run(applicativeId);
    }

    /**
     * Registra um pagamento.
     * 
     * @param payment
     * @return PaymentDTO contendo os detalhes do pagamento registrado
     */
    @PostMapping("/registrarpagamento")
    @CrossOrigin(origins = "*")
    public PaymentDTO registerPayment(@RequestBody RequestPayDTO payment) {
        return registerPayment.run(payment.getDay(), payment.getMonth(), payment.getYear(), payment.getSignatureCode(),
                payment.getValue(), payment.getSale());
    }

    /**
     * Verifica se uma assinatura é válida.
     * 
     * @param signatureCode
     * @return true se a assinatura for válida, false caso contrário
     */
    @GetMapping("/assinvalida/{signatureCode}")
    @CrossOrigin(origins = "*")
    public boolean isSignatureValid(@PathVariable long signatureCode) {
        return validSignature.run(signatureCode);
    }
}

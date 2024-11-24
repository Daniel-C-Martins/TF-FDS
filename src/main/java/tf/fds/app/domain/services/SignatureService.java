package tf.fds.app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.domain.repositories.ISignatureRepository;

@Service
public class SignatureService {
   private ISignatureRepository signatureRep;

   @Autowired
   public SignatureService(ISignatureRepository signatureRep) {
      this.signatureRep = signatureRep;
   }

   public SignatureModel createSignature(SignatureModel signature){
      return signatureRep.createSignature(signature);
   }

   public boolean isActive(long codass){
      return signatureRep.isActive(codass);
   }

   public List<SignatureModel> getAllSignatures(){
      return signatureRep.getAllSignatures();
   }

   public List<SignatureModel> getSignaturesByClient(long codcli){
      return signatureRep.getSignaturesByClient(codcli);
   }

   public List<SignatureModel> getSignaturesByApp(long codapp){
      return signatureRep.getSignaturesByApp(codapp);
   }
}

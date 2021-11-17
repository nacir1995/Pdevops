package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	Logger l = LoggerFactory.getLogger(EntrepriseServiceImpl.class);


	public int ajouterEntreprise(Entreprise entreprise) {
		l.debug("Method ajouterEntreprise");
		entrepriseRepoistory.save(entreprise);
		l.info("entreprise ajoutée avec succés et son  id egal = "+entreprise.getId());
		return entreprise.getId();
	}




	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		if (!(Integer.toString(entrepriseId).equals(""))) {
		l.info("Deleting Entreprise");
		try {
		Optional<Entreprise> contratManagedEntity = entrepriseRepoistory.findById(entrepriseId);
		if(contratManagedEntity.isPresent()) {
			Entreprise entreprise = contratManagedEntity.get();
		entrepriseRepoistory.delete(entreprise);
		}
		l.info("Entreprise Deleted Succefully ! ");
		}catch(Exception e) {
			l.error(e.toString());
		}
		}else {
			l.warn("No Contract To Delete ! ");
		}

	}



	public void getEntrepriseById(int entrepriseId) {
		if (!(Integer.toString(entrepriseId).equals(""))) {
			l.info("get entreprise");
			try {
			Optional<Entreprise> contratManagedEntity = entrepriseRepoistory.findById(entrepriseId);
			if(contratManagedEntity.isPresent()) {
				Entreprise entreprise = contratManagedEntity.get();			
			}
			l.info("affichage de l'entreprise ");
			}catch(Exception e) {
				l.error(e.toString());
			}
			}else {
				l.warn("No entreprise found! ");
			}

		}

}

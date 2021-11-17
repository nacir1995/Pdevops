package tn.esprit.spring;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

	
	
//	@Autowired
//	IEntrepriseService entrepriseService ;
	
	@Autowired IEntrepriseService entservice;
	
	int idEntreprise=5 ;


	
	@Test
	 public void testAjouterEntreprise() {
		 Entreprise ent=new Entreprise("MitraSociety","mitra");
		 entservice.ajouterEntreprise(ent);
			
					
		}



	 

@Test
public void testGetEtrepriseById(){
    
	entservice.getEntrepriseById(2);

}

@Test
public	void testDeleteEntrepriseById() {
	
	entservice.deleteEntrepriseById(idEntreprise);

}

	
	


}

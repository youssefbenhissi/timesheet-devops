package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class IEntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entrepriseRepository;
	private static final Logger l = LogManager.getLogger(IEntrepriseServiceImpl.class);

	@Override
	public List<Entreprise> retrieveAllEntreprises() {
		List<Entreprise> entreprises = null;
		try {
			l.info("In retrieveAllEntreprises(): ");
			entreprises = (List<Entreprise>) entrepriseRepository.findAll();
			for (Entreprise e : entreprises) {
				l.debug(e.toString());
			}
			l.info("Out retrieveAllEntreprises() without errors ");
		} catch (Exception e) {
			l.error("Erreur dans retrieveAllEntreprises():  " + e);
		}
		return entreprises;
	}

	@Override
	public Entreprise addEntreprise(Entreprise e) {
		l.info("In addEntreprise(): ");
		l.info("Out addEntreprise()");
		return entrepriseRepository.save(e);
	}


	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		l.info("In updateUser(): ");
		l.info("Out updateUser()");
		return entrepriseRepository.save(e);
	}

	@Override
	public Entreprise retrieveEntreprise(int id) {
		l.info("In retrieveEntreprise(): ");
		l.info("Out retrieveEntreprise()");
		return entrepriseRepository.findById(id).isPresent()
				? entrepriseRepository.findById(id).get() : null;
	}
	
	@Override
	public void deleteEntreprise(int id) {
		l.info("In deleteEntreprise(): ");
		entrepriseRepository.deleteById(id);
		l.info("Out deleteEntreprise()");
	}

}
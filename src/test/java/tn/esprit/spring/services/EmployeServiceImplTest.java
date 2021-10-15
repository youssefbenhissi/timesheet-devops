package tn.esprit.spring.services;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.EntrepriseRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {

	@Autowired
	private EmployeRepository employeRepository;

	
	@Autowired
	DepartementRepository deptRepoistory;

	@Autowired
	EntrepriseRepository entrepRepository;

	@Autowired
	ContratRepository contratRepoistory;

	@Autowired
	private EmployeServiceImpl employeService;

	private Employe employe1;
	private Employe employe2;
	private Entreprise entreprise;
	private Departement departement;
	Contrat contrat;

	/*@Before
	public void setUp() {
		entreprise = entrepRepository.save(new Entreprise("ESPRIT", "educatif"));
		departement = deptRepoistory.save(new Departement("Recherche"));
		departement.setEntreprise(entreprise);
		deptRepoistory.save(departement);

		employe1 = new Employe("Ferchichi", "Yasmine", "yasmine@gmail.com", true, Role.INGENIEUR);
		employe2 = new Employe("Korkad", "Nada", "nada@gmail.com", false, Role.INGENIEUR);
		employeRepository.save(employe1);
		employeRepository.save(employe2);
		employeService.affecterEmployeADepartement(employe1.getId(), departement.getId());

		contrat = contratRepoistory.save(new Contrat(new Date(2020, 04, 10), "CDI", 2000));
		contrat.setEmploye(employe1);
		contratRepoistory.save(contrat);
	}

	@After
	public void tearDown() {
		entrepRepository.deleteAll();
		deptRepoistory.deleteAll();
		contratRepoistory.deleteAll();
		employeRepository.deleteAll();
	}
*/
	@Test
	@Order(1)
	public void ajouterEmployeTest() {
		Employe savedEmploye = new Employe("Laffet", "Amal", "amal@gmail.com", false, Role.INGENIEUR);
		employeService.ajouterEmploye(savedEmploye);
		assertThat(savedEmploye.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void mettreAjourEmailByEmployeIdTest() {
		employeService.mettreAjourEmailByEmployeId("ferchichi@gmail.com", employe1.getId());
		assertThat(employeRepository.findById(employe1.getId()).get().getEmail()).isEqualTo("ferchichi@gmail.com");
	}

	@Test
	@Order(3)
	public void getEmployePrenomByIdTest() {
		String prenom = employeService.getEmployePrenomById(employe1.getId());
		assertThat(prenom).isEqualTo("Yasmine");
	}

	@Test
	@Order(4)
	public void deleteEmployeByIdTest() {
		employeService.deleteEmployeById(employe2.getId());
		Optional<Employe> deletedEmploye = employeRepository.findById(employe2.getId());
		assertThat(deletedEmploye).isEmpty();
	}

	@Test
	@Order(5)
	public void getNombreEmployeJPQLTest() {
		int nbr = employeService.getNombreEmployeJPQL();
		assertThat(nbr).isEqualTo(2);
	}

	@Test
	@Order(6)
	public void getAllEmployeNamesJPQLTest() {
		List<String> names = employeService.getAllEmployeNamesJPQL();
		assertThat(names.get(0)).isEqualTo(employe1.getNom());
		assertThat(names.get(1)).isEqualTo(employe2.getNom());
	}

	@Test
	@Order(7)
	public void getAllEmployeByEntrepriseTest() {
		List<Employe> employes = employeService.getAllEmployeByEntreprise(entreprise);
		assertThat(employes.size()).isEqualTo(1);
	}

	@Test
	@Order(8)
	public void mettreAjourEmailByEmployeIdJPQLTest() {
		employeService.mettreAjourEmailByEmployeIdJPQL("ferchichi@gmail.com", employe1.getId());
		assertThat(employeRepository.findById(employe1.getId()).get().getEmail()).isEqualTo("ferchichi@gmail.com");
	}

	@Test
	@Order(9)
	public void getSalaireByEmployeIdJPQLTest() {
		float salaire = employeService.getSalaireByEmployeIdJPQL(employe1.getId());
		assertThat(salaire).isEqualTo(2000);
	}

	@Test
	@Order(10)
	public void getAllEmployesTest() {
		List<Employe> employes = employeService.getAllEmployes();
		assertThat(employes.size()).isGreaterThan(0);
	}
}

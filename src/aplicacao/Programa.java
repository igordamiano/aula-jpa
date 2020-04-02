package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		//insert();
		//find();
		remove();
		
	}

	private static void remove() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		// com essa instanciação, vou ter conexão com o banco de dados e contexto de persistência implementada
		EntityManager em = emf.createEntityManager(); 
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

	private static void find() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		// com essa instanciação, vou ter conexão com o banco de dados e contexto de persistência implementada
		EntityManager em = emf.createEntityManager(); 
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

	private static void insert() {

		Pessoa p1 = new Pessoa(null, "Carlos", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Maria", "maria@gmail.com");
		Pessoa p3 = new Pessoa(null, "Joaquim", "joaquim@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		
		// com essa instanciação, vou ter conexão com o banco de dados e contexto de persistência implementada
		EntityManager em = emf.createEntityManager(); 
		// Jpa precisa de uma transação quando não for leitura
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		em.close();
		emf.close();
		System.out.println("Pronto!");
	}

}

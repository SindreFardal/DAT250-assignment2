package no.hvl.dat250.jpa.basicexample;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Todo t");
        List<Todo> todoList = q.getResultList();
        for (Todo todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Todo todo = new Todo();
        todo.setSummary("This is a test");
        todo.setDescription("This is a test");
        Person person = new Person();
        person.setName("Max Mustermann");
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);
        CreditCard creditcard1 = new CreditCard();
        creditcard1.setNumber(123);
        creditcard1.setLimit(2000);
        creditcard1.setBalance(1);
        CreditCard creditcard2 = new CreditCard();
        creditcard2.setNumber(12345);
        creditcard2.setLimit(-10000);
        creditcard2.setBalance(-5000);
        Bank bank = new Bank();
        bank.setName("Pengebank");
        person.getCreditcards().add(creditcard1);
        person.getCreditcards().add(creditcard2);
        person.getAddresses().add(address);
        creditcard1.setBankname(bank);
        creditcard2.setBankname(bank);
        creditcard1.setPincode(pincode);
        creditcard2.setPincode(pincode);
        creditcard1.getPincode();
        creditcard2.getPincode();
        creditcard1.getBankname();
        creditcard2.getBankname();




        em.persist(todo);
        em.persist(person);
        em.persist(address);
        em.persist(creditcard1);
        em.persist(creditcard2);
        em.persist(pincode);
        em.persist(bank);

        em.getTransaction().commit();
        em.close();


    }
}

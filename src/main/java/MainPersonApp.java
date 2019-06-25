import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class MainPersonApp {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("datasource");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();


      Person person1 = new Person();
        person1.setBirthDay(LocalDate.ofEpochDay(1986 - 18 - 10));
        person1.setFIRST_NAME("Eddy");
        person1.setLAST_NAME("Sa");
        person1.setVersion(22);
        person1.setComment("NICE GUY");
        person1.setMarried(true);
        person1.setGender(GenderType.MAN);
        person1.setHomePage("bushcraft.com");




        Person person2 = new Person();
        person2.setGender(GenderType.WOMAN);
        person2.setMarried(true);
        person2.setComment("NICE GIRL");
        person2.setVersion(21);
        person2.setLAST_NAME("Viskere");
        person2.setFIRST_NAME("Inta");
        person2.setBirthDay(LocalDate.ofEpochDay(1984-20-1));
        person2.setHomePage("blablabla.com");


        em.persist(person1);
        em.persist(person2);

        Person findP = em.find(Person.class,3);
        System.out.println(findP.toString());

        tx.commit();

        emf.close();


    }
}

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
        person1.setBirthDay(LocalDate.of(1986,10 ,18));
        person1.setFIRST_NAME("Eddy");
        person1.setLAST_NAME("Sa");
        person1.setVersion(22);
        person1.setComment("NICE GUY");
        person1.setMarried(true);
        person1.setGender(GenderType.MAN);
        person1.setHomePage("bushcraft.com");
        person1.setAge(30);
        person1.setAddress(new Address("heartStreet","3","1000","BRUSSEL","Belgie"));


        Person person2 = new Person();
        person2.setGender(GenderType.WOMAN);
        person2.setMarried(true);
        person2.setComment("NICE GIRL");
        person2.setVersion(21);
        person2.setLAST_NAME("Viskere");
        person2.setFIRST_NAME("Inta");
        person2.setBirthDay(LocalDate.of(1984,1,20));
        person2.setHomePage("blablabla.com");
        person2.setAge(32);

        Person person3 = new Person();
        person3.setAge(1);
        person3.setHomePage("hills.com");
        person3.setBirthDay(LocalDate.of(2018,4,29));
        person3.setFIRST_NAME("Ricky");
        person3.setLAST_NAME("Taki");
        person3.setVersion(1);
        person3.setComment("PURR");
        person3.setGender(GenderType.MAN);
        person3.setMarried(false);


        em.persist(person1);
        em.persist(person2);
        em.persist(person3);

        Person findP = em.find(Person.class,3);
        System.out.println(findP.toString());

        tx.commit();

        emf.close();


    }
}

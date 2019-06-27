import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;
import org.hibernate.boot.model.TypeContributions;
import org.hibernate.dialect.MySQLDialect;


@Entity
@Table(name = "person",indexes = {@Index(name = "LAST_NAME", columnList = "LastName"), @Index(columnList = "Birthday")})
@SecondaryTable(name = "URLS")
public class Person {

    public Person(Address address, long version, String FIRST_NAME, String LAST_NAME, LocalDate birthDay, GenderType gender, byte[] picture, String comment, boolean married, String homePage, int age) {
        this.address = address;
        this.version = version;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.birthDay = birthDay;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homePage = homePage;
        this.age = age;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;



    @Embedded
    private Address address;


    @Column(name = "Version")
    private long version;

    @Column(name = "FirstName", length = 40, nullable = false)
    private String FIRST_NAME;

    @Column(name = "LastName", length = 40, nullable = false)
    private String LAST_NAME;

    @Column(name = "Birthday")
    private LocalDate birthDay;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Lob
    @Column(name = "Picture")
    @Basic(fetch = FetchType.LAZY)
    private byte[] picture;

    @Column(name = "Comment")
    @Lob
    private String comment;

    @Column(name = "Married", columnDefinition = "BOOLEAN")
    private boolean married;

    @Column(name = "HomePage", table = "URLS") //, table = "URLS"
    private String homePage;

    @Column(name = "Age")
    private int age;

    public Address getAddress() {
        return address;
    }

    public Person setAddress(Address address) {
        this.address = address;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public Person(long version, String FIRST_NAME, String LAST_NAME, LocalDate birthDay, GenderType gender, byte[] picture, String comment, boolean married, String homePage, int age) {
        this.version = version;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.birthDay = birthDay;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homePage = homePage;
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public long getVersion() {
        return version;
    }

    public Person setVersion(long version) {
        this.version = version;
        return this;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public Person setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
        return this;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public Person setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public Person setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public GenderType getGender() {
        return gender;
    }

    public Person setGender(GenderType gender) {
        this.gender = gender;
        return this;
    }

    public byte[] getPicture() {
        return picture;
    }

    public Person setPicture(byte[] picture) {
        this.picture = picture;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Person setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public boolean isMarried() {
        return married;
    }

    public Person setMarried(boolean married) {
        this.married = married;
        return this;
    }

    public String getHomePage() {
        return homePage;
    }

    public Person setHomePage(String homePage) {
        this.homePage = homePage;
        return this;
    }

    public Person() {
    }



    @Override
    public String toString() {
        return String.format("Person{id=%d, address=%s, version=%d, FIRST_NAME='%s', LAST_NAME='%s', birthDay=%s, gender=%s, picture=%s, comment='%s', married=%s, homePage='%s', age=%d}", id, address, version, FIRST_NAME, LAST_NAME, birthDay, gender, Arrays.toString(picture), comment, married, homePage, age);
    }
}

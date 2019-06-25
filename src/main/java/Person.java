import javax.persistence.*;
import javax.xml.bind.annotation.XmlEnum;
import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Person {
    @Override
    public String toString() {
        return String.format("Person{id=%d, version=%d, FIRST_NAME='%s', LAST_NAME='%s', birthDay=%s, gender=%s, picture=%s, comment='%s', married=%s, homePage='%s'}", id, version, FIRST_NAME, LAST_NAME, birthDay, gender, picture, comment, married, homePage);
    }

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "Version")
    private long version;
    @Column(name = "FirstName")
    private String FIRST_NAME;
    @Column(name = "LastName")
    private String LAST_NAME;
    @Column(name = "Birthday")
    private LocalDate birthDay;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Lob
    private Blob picture;
    @Column(name = "Comment")
    private String comment;

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

    public Blob getPicture() {
        return picture;
    }

    public Person setPicture(Blob picture) {
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

    public Person(int id, long version, String FIRST_NAME, String LAST_NAME, LocalDate birthDay, GenderType gender, Blob picture, String comment, boolean married, String homePage) {
        this.id = id;
        this.version = version;
        this.FIRST_NAME = FIRST_NAME;
        this.LAST_NAME = LAST_NAME;
        this.birthDay = birthDay;
        this.gender = gender;
        this.picture = picture;
        this.comment = comment;
        this.married = married;
        this.homePage = homePage;
    }

    private boolean married;
    private String homePage;

}

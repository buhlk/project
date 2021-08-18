package pl.buhl.api.model;
import com.google.gson.annotations.SerializedName;
import javax.persistence.*;

@Entity
public class Insurance{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "policy_number")
    @SerializedName(value = "policy_number", alternate = "Nr polisy")
    private String policy_number;

    @Column(name = "policy_type")
    @SerializedName(value = "policy_type", alternate = "Typ polisy")
    private String policy_type;

    @Column(name = "policy_sum")
    @SerializedName(value = "policy_sum", alternate = "Suma ubezpiecznia")
    private Long policy_sum;

    @Column(name = "name")
    @SerializedName(value = "name", alternate = "Imię ubezpieczonego")
    private String name;
    @Column(name = "surname")
    @SerializedName(value = "surname", alternate = "Nazwisko ubezpieczonego")
    private String surname;
    @Column(name = "item")
    @SerializedName(value = "item", alternate = "Przedmiot ubezpieczonego")
    private String item;

    public Insurance(){}

    public Insurance(Long id, String policy_type, Long policy_sum, String name, String surname, String item) {
        this.id = id;
        this.policy_type = policy_type;
        this.policy_sum = policy_sum;
        this.name = name;
        this.surname = surname;
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicy_type() {
        return policy_type;
    }

    public void setPolicy_type(String policy_type) {
        this.policy_type = policy_type;
    }

    public Long getPolicy_sum() {
        return policy_sum;
    }

    public void setPolicy_sum(Long policy_sum) {
        this.policy_sum = policy_sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Insurance{" +
                "id=" + id +
                ", policy_type='" + policy_type + '\'' +
                ", policy_sum=" + policy_sum +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
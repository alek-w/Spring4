package net.thumbtack.be.persistence.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "account")
public class Account implements Serializable {

    static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "id", nullable = false)
    private long id; // a surrogate is needed cause several people could have common account

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "iban", nullable = false)
//    @NotNull
    private String iban;

    @Column(name = "bic", nullable = false)
    private String bic;

    public long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("iban='").append(iban).append('\'');
        sb.append(", bic='").append(bic).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Account(String iban, String bic) {
        this.iban = iban;
        this.bic = bic;
    }
    public Account() {}
}

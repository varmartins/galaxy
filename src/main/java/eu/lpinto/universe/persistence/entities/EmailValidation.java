package eu.lpinto.universe.persistence.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author Luis Pinto <code>- mail@lpinto.eu</code>
 */
@Entity
@Table(name = "EmailVerification")
public class EmailValidation extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String email;
    private String code;
    private String baseUrl;

    /*
     * Contructors
     */
    public EmailValidation() {
    }

    public EmailValidation(Long id) {
        super(id);
    }

    public EmailValidation(String email, String baseUrl, String name) {
        super(name);
        this.email = email;
        this.baseUrl = baseUrl;
    }

    public EmailValidation(final String email, final String name, final String baseUrl,
                             final User creator, final Calendar created, final User updater, final Calendar updated, final Long id) {
        super(name, creator, created, updater, updated, id);
        this.email = email;
        this.baseUrl = baseUrl;
        this.code = null;
        setCode();
    }

    /*
     * Getters/Setters
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode() {
        this.code = System.currentTimeMillis() + String.format("%05d", getId());
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getUrl() {
        return baseUrl + code;
    }
}

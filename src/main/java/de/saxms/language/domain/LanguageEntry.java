package de.saxms.language.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A LanguageEntry.
 */
@Entity
@Table(name = "language_entry")
public class LanguageEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entry_value")
    private String entryValue;

    @Column(name = "last_update")
    private Instant lastUpdate;

    @ManyToOne
    @JsonIgnoreProperties("languageEntries")
    private LanguageLocale languageLocale;

    @ManyToOne
    @JsonIgnoreProperties("languageEntries")
    private LanguageKey languageKey;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryValue() {
        return entryValue;
    }

    public LanguageEntry entryValue(String entryValue) {
        this.entryValue = entryValue;
        return this;
    }

    public void setEntryValue(String entryValue) {
        this.entryValue = entryValue;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public LanguageEntry lastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public LanguageLocale getLanguageLocale() {
        return languageLocale;
    }

    public LanguageEntry languageLocal(LanguageLocale languageLocale) {
        this.languageLocale = languageLocale;
        return this;
    }

    public void setLanguageLocale(LanguageLocale languageLocale) {
        this.languageLocale = languageLocale;
    }

    public LanguageKey getLanguageKey() {
        return languageKey;
    }

    public LanguageEntry languageKey(LanguageKey languageKey) {
        this.languageKey = languageKey;
        return this;
    }

    public void setLanguageKey(LanguageKey languageKey) {
        this.languageKey = languageKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LanguageEntry languageEntry = (LanguageEntry) o;
        if (languageEntry.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), languageEntry.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "LanguageEntry{" +
            "id=" + getId() +
            ", entryValue='" + getEntryValue() + "'" +
            ", lastUpdate='" + getLastUpdate() + "'" +
            "}";
    }
}

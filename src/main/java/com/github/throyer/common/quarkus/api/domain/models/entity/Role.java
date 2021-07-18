package com.github.throyer.common.quarkus.api.domain.models.entity;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "role")
public class Role implements Serializable {

    private static final long serialVersionUID = -8524505911742593369L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true, unique = true)
    private String name;

    @JsonIgnore
    @Column(name = "deleted_name")
    private String deletedName;

    @Column(name = "initials", nullable = true, unique = true)
    private String initials;

    @JsonIgnore
    @Column(name = "deleted_initials")
    private String deletedInitials;

    @Column(nullable = true, unique = true)
    private String description;

    public Role() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeletedName() {
        return deletedName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getDeletedInitials() {
        return deletedInitials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Role)) {
            return false;
        }
        Role role = (Role) object;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
    @Override
    public String toString() {
        return Optional
                .ofNullable(name)
                    .orElseGet(() -> "");
    }
}

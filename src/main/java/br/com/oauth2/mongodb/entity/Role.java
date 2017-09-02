/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.oauth2.mongodb.entity;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author nataniel
 */
@Document
public class Role implements GrantedAuthority {

    @Id
    private String id;

    @NotNull(message = "NAME_REQUIRED")
    private String name;

    private String nameCommon;

    private Boolean isDeleted;

    public Role(String name, String nameCommon, Boolean isDeleted) {
        this.name = name;
        this.nameCommon = nameCommon;
        this.isDeleted = isDeleted;
    }

    public Role() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCommon() {
        return nameCommon;
    }

    public void setNameCommon(String nameCommon) {
        this.nameCommon = nameCommon;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}

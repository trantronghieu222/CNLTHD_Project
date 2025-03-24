package com.shop.watch.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "Account_permission")
@Data
@Schema(description = "Represents a role or permission in the system")
public class PermissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Integer permissionId;
    @Column(name = "permission_name")
    private String permissionName;
    @OneToMany(mappedBy = "permission", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<AccountModel> accounts;

    // Constructor
    public PermissionModel(){}

    public PermissionModel(Integer permissionId, String permissionName) {
        this.permissionId = permissionId;
        this.permissionName = permissionName;
    }

    // Getter & Setter


    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Set<AccountModel> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AccountModel> accounts) {
        this.accounts = accounts;
    }
}

package com.mood.Moodania.dataAccess.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Accounts",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "email")
        })

public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Nonnull
    private String email;
    @Nonnull
    private String password;
    @Nonnull
    private LocalDate registrationDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleId", referencedColumnName = "id", nullable = false)
    private RoleEntity role;


    public AccountEntity() {}

    public AccountEntity(@Nonnull String email, @Nonnull String password, @Nonnull LocalDate registrationDate, @Nonnull UserEntity user, @NonNull RoleEntity role) {
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.user = user;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(@Nonnull UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@Nonnull String email) {
        this.email = email;
    }

    public void setPassword(@Nonnull String password) {
        this.password = password;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(@Nonnull LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(@Nonnull UserEntity user) {
        this.user = user;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

}

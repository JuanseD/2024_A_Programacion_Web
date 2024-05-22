package com.example.segundo_parcial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    private Long roleId;

    @Column(name = "rolename")
    private String roleName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role(String roleName, String description, Menu menu) {
        this.roleName = roleName;
        this.description = description;
        this.menu = menu;
    }
}

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
@Table(name = "menus")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuId")
    private Long menuId;

    @Column(name = "menuName")
    private String menuName;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "menu")
    private List<SubMenu> submenus;

    public Menu(String menuName, String description, Role role) {
        this.menuName = menuName;
        this.description = description;
        this.role = role;
    }
}

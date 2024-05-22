package com.example.segundo_parcial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "submenus")
public class SubMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "submenuId")
    private Long submenuId;

    @Column(name = "submenuname")
    private String submenuname;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public SubMenu(String submenuname, String description, Menu menu) {
        this.submenuname = submenuname;
        this.description = description;
        this.menu = menu;
    }
}


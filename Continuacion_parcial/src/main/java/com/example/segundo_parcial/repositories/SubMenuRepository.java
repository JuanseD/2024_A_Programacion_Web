package com.example.segundo_parcial.repositories;

import com.example.segundo_parcial.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, Long> {
}

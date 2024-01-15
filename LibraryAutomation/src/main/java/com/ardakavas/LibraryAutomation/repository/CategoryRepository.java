package com.ardakavas.LibraryAutomation.repository;


import com.ardakavas.LibraryAutomation.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}

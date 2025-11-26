package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.domain.News;

public interface NewsRepository extends JpaRepository<News, Long> {
    
}

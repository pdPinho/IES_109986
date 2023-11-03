package ua.pt.app.repository;

import ua.pt.app.entity.Quote;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuoteRepository extends JpaRepository<Quote, Long> {}
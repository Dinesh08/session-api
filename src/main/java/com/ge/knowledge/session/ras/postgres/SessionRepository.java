package com.ge.knowledge.session.ras.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.knowledge.session.domain.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

    Session findById(final Long id);
}

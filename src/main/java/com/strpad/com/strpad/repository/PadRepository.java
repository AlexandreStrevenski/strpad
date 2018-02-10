package com.strpad.com.strpad.repository;


import com.strpad.com.strpad.entity.Pad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PadRepository extends JpaRepository<Pad, Long>{

    Optional<Pad> findByUrl(String url);
}

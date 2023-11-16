package com.jmcr.consumomarvelapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmcr.consumomarvelapirest.entity.Bitacora;

/**
 * Repository of bitacora
 */
public interface IBitacoraRepository extends JpaRepository<Bitacora, Long> {

}

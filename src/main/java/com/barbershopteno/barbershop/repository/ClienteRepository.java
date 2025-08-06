package com.barbershopteno.barbershop.repository;


import com.barbershopteno.barbershop.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);

    @Query(value = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    List<Cliente> findByCpfTeste(String cpf);
}

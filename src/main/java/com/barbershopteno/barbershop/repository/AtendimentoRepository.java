package com.barbershopteno.barbershop.repository;


import com.barbershopteno.barbershop.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    @Query("SELECT MAX(a.senha) FROM Atendimento a WHERE DATE(a.dataHora) = CURRENT_DATE")
    Integer findUltimaSenhaDoDia();
}

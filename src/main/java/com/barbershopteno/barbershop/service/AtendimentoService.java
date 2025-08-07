package com.barbershopteno.barbershop.service;

import com.barbershopteno.barbershop.entity.Atendimento;
import com.barbershopteno.barbershop.entity.Barbeiro;
import com.barbershopteno.barbershop.entity.Cliente;
import com.barbershopteno.barbershop.entity.Servico;
import com.barbershopteno.barbershop.repository.AtendimentoRepository;
import com.barbershopteno.barbershop.repository.BarbeiroRepository;
import com.barbershopteno.barbershop.repository.ClienteRepository;
import com.barbershopteno.barbershop.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;


    public Atendimento criarAtendimento(String cpf, Long idBarbeiro, Long idServico) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Barbeiro barbeiro = barbeiroRepository.findById(idBarbeiro)
                .orElseThrow(() -> new RuntimeException("Barbeiro não encontrado"));

        Servico servico = servicoRepository.findById(idServico)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        Integer ultimaSenha = atendimentoRepository.findUltimaSenhaDoDia();
        int novaSenha = (ultimaSenha == null) ? 1 : ultimaSenha + 1;

        Atendimento atendimento = new Atendimento();
        atendimento.setCliente(cliente);
        atendimento.setBarbeiro(barbeiro);
        atendimento.setServico(servico);
        atendimento.setSenha(novaSenha);
        atendimento.setDataHora(LocalDateTime.now());

        return atendimentoRepository.save(atendimento);

    }

    public List<Atendimento> listarTodos() {
        return atendimentoRepository.findAll();
    }

    public List<Atendimento> listarAtendimentoPorIdBarbeiro(Long id) {
        return atendimentoRepository.findAtendimentoBarbeiro(id);
    }
}

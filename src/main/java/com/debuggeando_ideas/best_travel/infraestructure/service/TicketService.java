package com.debuggeando_ideas.best_travel.infraestructure.service;

import com.debuggeando_ideas.best_travel.api.models.request.TicketRequest;
import com.debuggeando_ideas.best_travel.api.models.responses.FlyResponse;
import com.debuggeando_ideas.best_travel.api.models.responses.TicketResponse;
import com.debuggeando_ideas.best_travel.domain.entitites.jpa.TicketEntity;
import com.debuggeando_ideas.best_travel.domain.repositories.jpa.CustomerRepository;
import com.debuggeando_ideas.best_travel.domain.repositories.jpa.FlyRepository;
import com.debuggeando_ideas.best_travel.domain.repositories.jpa.TicketRepository;
import com.debuggeando_ideas.best_travel.infraestructure.abstract_service.ITicketService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class TicketService implements ITicketService {

    private final FlyRepository flyRepository;
    private final CustomerRepository customerRepository;
    private final TicketRepository ticketRepository;


    @Override
    public TicketResponse create(TicketRequest request) {
        var fly = flyRepository.findById(request.getFly()).orElseThrow();
        var customer = customerRepository.findById(request.getIdClient()).orElseThrow();

        var ticketToPersist = TicketEntity.builder()
                .id(UUID.randomUUID())
                .fly(fly)
                .customer(customer)
                .price(fly.getPrice().multiply(BigDecimal.valueOf(0.25)))
                .purchaseDate(LocalDate.now())
                .arrivalDate(LocalDateTime.now())
                .departureDate(LocalDateTime.now());

        var ticketPersisted = this.ticketRepository.save(ticketToPersist);

        log.info('Ticket saved with id:{}', ticketPersisted.getId());
        return null;
    }

    @Override
    public TicketResponse read(UUID uuid) {
        return null;
    }

    @Override
    public TicketResponse update(TicketRequest request, UUID uuid) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }

    private TicketResponse entityToResponse(TicketEntity entity) {
        var response = new TicketResponse();
        // response.setId(entity.getId());
        // response.setArrivalDate(entity.getArrivalDate());
        BeanUtils.copyProperties(entity, response);
        var flyResponse = new FlyResponse();
        BeanUtils.copyProperties(entity.getFly(), flyResponse);
        return response;
    }
}

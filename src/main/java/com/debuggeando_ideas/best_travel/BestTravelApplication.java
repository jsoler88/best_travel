package com.debuggeando_ideas.best_travel;

import com.debuggeando_ideas.best_travel.domain.repositories.jpa.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class BestTravelApplication implements CommandLineRunner {

    private final HotelRepository hotelRepository;
    private final FlyRepository flyRepository;
    private final TicketRepository ticketRepository;
    private final ReservationRepository reservationRepository;
    private final TourRepository tourRepository;
    private final CustomerRepository customerRepository;

    public BestTravelApplication(
            HotelRepository hotelRepository,
            FlyRepository flyRepository,
            TicketRepository ticketRepository,
            ReservationRepository reservationRepository,
            TourRepository tourRepository,
            CustomerRepository customerRepository
    ) {
        this.hotelRepository = hotelRepository;
        this.flyRepository = flyRepository;
        this.ticketRepository = ticketRepository;
        this.reservationRepository = reservationRepository;
        this.tourRepository = tourRepository;
        this.customerRepository = customerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(BestTravelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        var fly = flyRepository.findById(15L).get();
//        var hotel = hotelRepository.findById(7L).get();
//        var ticket = ticketRepository.findById(UUID.fromString("32345678-1234-5678-4234-567812345678")).get();
//        var reservation = reservationRepository.findById(UUID.fromString("12345678-1234-5678-1234-567812345678")).get();
//        var customer = customerRepository.findById("VIKI771012HMCRG093").get();
//
//        log.info(String.valueOf(fly));
//        log.info(String.valueOf(hotel));
//        log.info(String.valueOf(ticket));
//        log.info(String.valueOf(reservation));
//        log.info(String.valueOf(customer));

//    this.flyRepository.selectLessPrice(BigDecimal.valueOf(20)).forEach(System.out::println);
//    this.flyRepository.selectBetweenPrice(BigDecimal.valueOf(10), BigDecimal.valueOf(15)).forEach(System.out::println);

        var fly = flyRepository.findById(1L).get();
        System.out.println(fly);

        fly.getTickets().forEach(ticket -> System.out.println(ticket));

        var flyRepo = this.flyRepository.findByTicketId(UUID.fromString("32345678-1234-5678-4234-567812345678"));
        System.out.println(flyRepo);
    }


}

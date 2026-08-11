package com.example.parking.service.impl;

import com.example.parking.dto.response.TicketSummaryResponse;
import com.example.parking.repository.ParkingTicketRepository;
import com.example.parking.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final ParkingTicketRepository ticketRepository;

    @Override
    public List<TicketSummaryResponse> getTodayTicketSummaries() {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);

        return ticketRepository.findTodayTicketSummaries(startOfDay, endOfDay);
    }
}

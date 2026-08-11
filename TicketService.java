package com.example.parking.service;

import com.example.parking.dto.response.TicketSummaryResponse;
import java.util.List;

public interface TicketService {
    List<TicketSummaryResponse> getTodayTicketSummaries();
}

package com.example.parking.controller;

import com.example.parking.dto.response.ApiResponse;
import com.example.parking.dto.response.TicketSummaryResponse;
import com.example.parking.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @GetMapping("/summary")
    public ResponseEntity<ApiResponse<List<TicketSummaryResponse>>> getTodayTicketSummaries() {
        List<TicketSummaryResponse> summaryList = ticketService.getTodayTicketSummaries();

        ApiResponse<List<TicketSummaryResponse>> response = ApiResponse.<List<TicketSummaryResponse>>builder()
                .success(true)
                .message("Lấy danh sách tóm tắt vé xe trong ngày thành công")
                .data(summaryList)
                .build();

        return ResponseEntity.ok(response);
    }
}

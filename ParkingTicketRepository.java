package com.example.parking.repository;

import com.example.parking.dto.response.TicketSummaryResponse;
import com.example.parking.entity.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ParkingTicketRepository extends JpaRepository<ParkingTicket, Long> {

    @Query("SELECT new com.example.parking.dto.response.TicketSummaryResponse(" +
           "t.id, v.licensePlate, z.name, t.checkInTime, t.checkOutTime) " +
           "FROM ParkingTicket t " +
           "JOIN t.vehicle v " +
           "JOIN t.zone z " +
           "WHERE t.checkInTime >= :startOfDay AND t.checkInTime <= :endOfDay")
    List<TicketSummaryResponse> findTodayTicketSummaries(
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay
    );
}

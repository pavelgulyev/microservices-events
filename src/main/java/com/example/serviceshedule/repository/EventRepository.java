package com.example.serviceshedule.repository;


import com.example.serviceshedule.entity.Event;
import com.example.serviceshedule.entity.groupUniversity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(
            value = "SELECT * FROM event where event.type_event_type_eventid = ?1",
            nativeQuery = true
    )
    List<Event> findByTypeEvent(Long type_event_id);
    @Query(
            value = "SELECT * FROM event where event.class_event_class_event_id = ?1",
            nativeQuery = true
    )
    List<Event> findByClassEvent(Long class_event_id);
//    @Query(
//            value = "SELECT * FROM event WHERE DATE(date_end_event) = ?1",
//            nativeQuery = true
//    )
//    List<groupUniversity> findByDateEvent(Date type_event_id);
//    @Query(
//            value = "SELECT * FROM event WHERE DATE(add_date) BETWEEN ?1 AND ?2\n",
//            nativeQuery = true
//    )
//    List<groupUniversity> findByBetweenDateEvent(Date type_event_id);
    @Query(
            value = "SELECT * FROM event where event.user_sсhedule_user_schedule_id = ?1",
            nativeQuery = true
    )
    List<Event> findByUserSсhedule(Long id);
    @Query(
            value = "SELECT * FROM event join user_shedule on event.user_sсhedule_user_schedule_id = user_shedule.user_schedule_id  \n" +
                    "where login like %?1%",
            nativeQuery = true
    )
    List<Event> getByUserLogin(String login);
    @Query("FROM Event WHERE dateStartEvent BETWEEN :startTime AND :endTime")
    List<Event> findAllEventWithDateRange(
            @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);
    @Query("FROM Event WHERE DATE(dateStartEvent) = DATE(:startTime)")
    List<Event> findAllEventWithDateDayStart(
            @Param("startTime") LocalDateTime startTime);
    @Query(
            value = "SELECT * FROM event join location on event.location_id=location.location_id " +
                    "where location.namelocation like %?1%",
            nativeQuery = true
    )
    List<Event> getByLocation(String namelocation);
}

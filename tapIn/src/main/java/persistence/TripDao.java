package persistence;

import entity.trip;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

public interface TripDao extends JpaRepositry<trip,Integer>{

    public List<trip> searchTripByCustomerId(Integer customerId);

    @Modifying
    @Transactional
    @Query(value= "insert into journey values(:tripId,stationId,customerId,SwipeInStation,SwipeOutStation,SwipeInDateAndTime,SwipeOutStationDateAndTime,tripFare)",nativeQuery = true)
    int createTrip(@Param("tripId")int tripId,
                   @Param("stationId")int stationId,
                   @Param("customerId")int customerId,
                   @Param("SwipeInStation")String SwipeInStation,
                   @Param("SwipeOutStation")String SwipeOutStation,
                   @Param("SwipeInDateAndTime")LocalDateTime SwipeInDateAndTime,
                   @Param("SwipeOutDateAndTime")LocalDateTime SwipeOutDateAndTime,
                   @Param("tripFare")double tripFare);

}




}

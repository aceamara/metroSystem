package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class trip {

    @Id
    @GeneratedValue

    private int customerId;
    private int tripId;
    private String SwipeInStation;
    private String SwipeOutStation;
    private LocalDateTime SwipeInDateAnTime;
    private LocalDateTime SwipeOutDateAndTime;
    private double tripFare;
}

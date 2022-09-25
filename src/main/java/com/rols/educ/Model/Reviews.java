package com.rols.educ.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
    @Id
    private Long reviewsId;

    private int rating;
    private long computedRating;

}

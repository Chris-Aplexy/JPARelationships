package com.rols.educ.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private Long courseId;

    private String referenceId;
    private String courseTittle;
    private String courseName;
    private String courseDescription;
    private String tutorName;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comments;
    @ManyToOne
    @JoinColumn(name = "reviews_id")
    private Reviews reviews;
    private Date startDate;
    private Date endDate;
    private String imageUrl;
    private List<String> videoUrls;

}
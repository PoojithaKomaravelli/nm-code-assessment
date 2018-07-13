package com.nm.cascade.web.category.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by PKomaravelli on 7/13/2018.
 */
@Entity
@Data
@Builder

public class QuestionAnswerDetails {

    @Id
    private String questionAnswerRelId;
}

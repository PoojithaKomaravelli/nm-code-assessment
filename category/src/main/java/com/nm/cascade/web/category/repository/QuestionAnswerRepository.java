package com.nm.cascade.web.category.repository;

import com.nm.cascade.web.category.models.QuestionAnswerDetails;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by PKomaravelli on 7/13/2018.
 */
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswerDetails,String> {
}

package com.dailycodebuffer.sentiment.repository;

import com.dailycodebuffer.sentiment.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {
}

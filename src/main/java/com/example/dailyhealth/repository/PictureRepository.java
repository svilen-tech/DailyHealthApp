package com.example.dailyhealth.repository;

import com.example.dailyhealth.model.PictureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<PictureEntity,Long> {
    void deleteAllByPublicId(String publicId);
}

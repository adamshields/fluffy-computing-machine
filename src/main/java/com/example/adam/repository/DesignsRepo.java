package com.example.adam.repository;


import com.example.adam.model.DesignsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesignsRepo  extends JpaRepository<DesignsModel, Integer> {

//    @Query(value = "SELECT design_id, design_version FROM design_revisions WHERE design_status =\"Present\" AND app_id = :appId", nativeQuery = true)
//    String getPresentDesign(@Param("appId") Integer appId);
    @Query(value = "SELECT * FROM design_revisions WHERE design_status = 'Present' AND app_id = :appId", nativeQuery = true)
    DesignsModel getPresentDesign(@Param("appId") Integer appId);


//    @Query(value = "SELECT app_id FROM design_revisions", nativeQuery = true)
//    List<Integer> checkAppIdExists();
    @Query(value = "SELECT DISTINCT app_id FROM design_revisions WHERE app_id IS NOT NULL", nativeQuery = true)
    List<Integer> checkAppIdExists();

    List<DesignsModel> findByAppId(Integer appId);
}

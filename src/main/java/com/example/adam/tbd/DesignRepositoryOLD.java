package com.example.adam.tbd;
import com.example.adam.tbd.Design;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface DesignRepositoryOLD extends JpaRepository<Design, Long> {


}
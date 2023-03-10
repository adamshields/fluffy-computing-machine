package com.example.adam;

import com.example.adam.entity.Design;
import com.example.adam.repository.DesignRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
public class DesignRepositoryTest {

    @Autowired
    private DesignRepository designRepository;

    @Test
    public void testRepositoryNotNull() {
        assertNotNull(designRepository);
    }

    @Test
    public void testFindById() {
        // Create a new Design and save it to the database
        Design design = new Design();
        design.setDesignName("Test Design");
        design.setAppImpactId(1);
        design.setAppId(2);
        design.setDesignStatus("Future");
        design.setDesignBase("Test Base");
        design.setDesignApproval("Draft");
        designRepository.save(design);

        // Retrieve the Design from the database using its ID
        Optional<Design> result = designRepository.findById(design.getDesignId());

        // Verify that the retrieved Design matches the original Design
        assertTrue(result.isPresent());
        Design retrievedDesign = result.get();
        assertEquals(design.getDesignName(), retrievedDesign.getDesignName());
        assertEquals(design.getAppImpactId(), retrievedDesign.getAppImpactId());
        assertEquals(design.getAppId(), retrievedDesign.getAppId());
        assertEquals(design.getDesignStatus(), retrievedDesign.getDesignStatus());
        assertEquals(design.getDesignBase(), retrievedDesign.getDesignBase());
        assertEquals(design.getDesignApproval(), retrievedDesign.getDesignApproval());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.accountManagement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kimmo
 */
public interface SkillRepository extends JpaRepository<Skill, Long>{
    Skill findByName(String name);
    
}

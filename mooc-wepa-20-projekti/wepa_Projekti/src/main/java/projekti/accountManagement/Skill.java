/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekti.accountManagement;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author kimmo
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill extends AbstractPersistable<Long> implements Serializable, Comparable<Skill> {
    
    private String name;
    private Long likes;
    
    @ManyToMany
    private List<Profile> profilesWithSkill;
    
    public void likeSkill() {
        this.likes++;
    }
    
    @Override
    public int compareTo(Skill o) {
        return o.getLikes().compareTo(this.getLikes());
    }
    
}

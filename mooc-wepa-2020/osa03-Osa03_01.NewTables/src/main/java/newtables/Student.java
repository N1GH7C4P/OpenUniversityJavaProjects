/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtables;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity; 
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 *
 * @author kimmo
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student extends AbstractPersistable<Long> {
    String first_name;
    String last_name;
    
    @ManyToMany
    @JoinTable(
        name="Enrollment",
        joinColumns = 
            @JoinColumn(name="course_id", referencedColumnName="ID"),
        inverseJoinColumns =
            @JoinColumn(name="student_id", referencedColumnName="ID")
    )
    private List<Course> courses;
}
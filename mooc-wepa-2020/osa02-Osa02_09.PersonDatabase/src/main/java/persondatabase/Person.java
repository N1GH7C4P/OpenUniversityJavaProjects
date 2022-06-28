/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persondatabase;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author kimmo
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Person extends AbstractPersistable<Long> {
    private String name;
}

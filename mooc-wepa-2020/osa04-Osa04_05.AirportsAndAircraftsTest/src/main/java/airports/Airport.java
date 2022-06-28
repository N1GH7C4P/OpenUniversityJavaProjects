package airports;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints={@UniqueConstraint(columnNames = "name")})
public class Airport extends AbstractPersistable<Long> {
    
    @OneToMany(mappedBy = "airport", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Aircraft> aircrafts;
    private String identifier;
    private String name;
}

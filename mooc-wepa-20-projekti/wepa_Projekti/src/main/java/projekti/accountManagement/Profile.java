package projekti.accountManagement;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
import projekti.imageHosting.FileObject;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile extends AbstractPersistable<Long> implements Serializable {

    @OneToMany(mappedBy = "sender")
    private List<Message> messages;
    
    @ManyToMany
    private List<Message> likedMessages;
    
    @NotEmpty
    @Size(min = 4, max = 50)
    @Column(unique=true)
    private String username;
    
    private String name;
    
    @ManyToMany()
    private List<Profile> friends;
    
    @Column(length = 100)
    private String password;
    
    @OneToOne
    private FileObject profilePic;
    private boolean hasProfilePic = false;
    
    @ManyToMany(mappedBy = "profilesWithSkill")
    private List<Skill> skills;
    
}

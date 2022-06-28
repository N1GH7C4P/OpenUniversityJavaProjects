package todoapplication;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    private String identifier;
    private String name;
    private int checked;

    public Item(String name) {
        this.identifier = UUID.randomUUID().toString();
        this.name = name;
        this.checked = 0;
    }
    public void Visit() {
        this.checked++;
    }
}
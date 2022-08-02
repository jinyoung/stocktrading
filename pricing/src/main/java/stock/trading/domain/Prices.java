package stock.trading.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Prices_table")
@Data
public class Prices {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String item;

    private Double price;
}

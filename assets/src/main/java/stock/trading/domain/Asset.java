package stock.trading.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Asset_table")
@Data
public class Asset {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private String item;

    private Double amount;
    private String accountId;
}

package team.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private Long flowerId;
    private Float price;
    private Date payDate;
    private String cardNo;
    private Long orderId;
    private Integer qty;
}



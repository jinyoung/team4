package team.external;

import lombok.Data;
import java.util.Date;
@Data
public class Store {

    private Long id;
    private Long flowerId;
    private String flowerName;
    private Integer flowerCnt;
    private Long orderId;
    private Double flowerPrice;
}



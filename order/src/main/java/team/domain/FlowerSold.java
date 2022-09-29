package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class FlowerSold extends AbstractEvent {

    private Long id;
    private String flowerId;
    private String flowerName;
    private Integer flowerCnt;
    private Boolean packingYn;
    private String orderId;
}



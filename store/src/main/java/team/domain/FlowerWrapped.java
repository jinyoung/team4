package team.domain;

import team.domain.*;
import team.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FlowerWrapped extends AbstractEvent {

    private Long id;
    private String flowerId;
    private String flowerName;
    private Integer flowerCnt;
    private Boolean packingYn;
    private String orderId;

    public FlowerWrapped(Store aggregate){
        super(aggregate);
    }
    public FlowerWrapped(){
        super();
    }
}

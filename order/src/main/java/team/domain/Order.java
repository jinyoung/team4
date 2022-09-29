package team.domain;

import team.domain.OrderCancelled;
import team.domain.OrderPlaced;
import team.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Order_table")
@Data

public class Order  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long flowerId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private Date orderDate;
    
    
    
    
    
    private Boolean isOffline;
    
    
    
    
    
    private Date orderCancelDate;
    
    
    
    
    
    private String phoneNumber;
    
    
    
    
    
    private Double price;

    @PostPersist
    public void onPostPersist(){


        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();


        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        team.external.Payment payment = new team.external.Payment();

        payment.setOrderId(getId());
        payment.setPrice(getPrice().floatValue());

        // mappings goes here
        OrderApplication.applicationContext.getBean(team.external.PaymentService.class)
            .pay(payment);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }




    public static void updateStatus(FlowerSold flowerSold){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(flowerSold.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(DeliveryCompleted deliveryCompleted){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }
    public static void updateStatus(DeliveryCanceled deliveryCanceled){

        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

        
    }


}

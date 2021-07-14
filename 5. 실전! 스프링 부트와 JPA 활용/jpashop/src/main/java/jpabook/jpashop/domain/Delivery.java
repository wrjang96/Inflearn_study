package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @JsonIgnore
    @OneToOne
    private Order order;
    
    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // ENUMTYPE의 경우 ORDINAL 쓰면 안됨(숫자로 들어가기 떄문)
    private DeliveryStatus status;
    
    
}

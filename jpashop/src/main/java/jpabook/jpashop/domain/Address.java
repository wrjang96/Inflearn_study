package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // JPA 내장 타입
@Getter
// 값 타입은 변경 불가능하게 설계해야 하므로 SETTER제거하고 값을 모두 초기화해서 변경 불가능한 클래스를 만들자
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address(){

    }
    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }


}

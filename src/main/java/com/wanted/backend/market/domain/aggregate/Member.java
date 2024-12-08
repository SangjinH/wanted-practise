package com.wanted.backend.market.domain.aggregate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "buyer")
    private List<Order> orderList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<Goods> goodsList;
}

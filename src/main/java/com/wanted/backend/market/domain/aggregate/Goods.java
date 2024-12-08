package com.wanted.backend.market.domain.aggregate;

import com.wanted.backend.market.domain.valueobject.GoodsStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private GoodsStatus status;

    @ManyToOne
    private Member seller;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goods")
    private List<Order> orderList;
}

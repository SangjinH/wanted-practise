package com.wanted.backend.market.domain.repository;

import com.wanted.backend.market.domain.aggregate.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}

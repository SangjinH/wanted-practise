package com.wanted.backend.market.application.queryservice;

import com.wanted.backend.market.common.exceptions.ApiException;
import com.wanted.backend.market.domain.aggregate.Goods;
import com.wanted.backend.market.domain.aggregate.Member;
import com.wanted.backend.market.domain.query.GoodsDetailQuery;
import com.wanted.backend.market.domain.repository.GoodsRepository;
import com.wanted.backend.market.domain.repository.MemberRepository;
import com.wanted.backend.market.domain.repository.OrderRepository;
import com.wanted.backend.market.domain.view.GoodsDetailView;
import com.wanted.backend.market.domain.view.GoodsView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.wanted.backend.market.common.constants.ResponseCode.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoodsQueryService {

    private final GoodsRepository goodsRepository;
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;

    public List<GoodsView> findAll() {

        return goodsRepository.findAll().stream()
                .map(GoodsView::new)
                .collect(Collectors.toList());
    }

    public GoodsDetailView findById(GoodsDetailQuery detailQuery) {
        Optional<Goods> findGoods = goodsRepository.findById(detailQuery.getGoodsId());
        if (findGoods.isEmpty()) throw new ApiException(INVALID_PARAMETER, "찾는 상품이 존재하지 않습니다.");

        Optional<Member> findMember = memberRepository.findById(detailQuery.getMemberId());

        // 비회원 or 조회한 회원이 없는경우, 상품정보만 전달
        if (isNonMember(detailQuery) || findMember.isEmpty()) return new GoodsDetailView(findGoods.get());

        Member member = findMember.get();
        Goods goods = findGoods.get();

        // 상품의 판매자가 본인이면, 판매리스트
        if (goods.getSeller().equals(member))
            return GoodsDetailView.getSalesDetailView(goods, orderRepository.findByGoods(goods));

        else // 상품의 판매자가 본인이 아니면, 구매리스트
            return GoodsDetailView.getPurchaseDetailView(goods, orderRepository.findByBuyer(member));
    }

    private boolean isNonMember(GoodsDetailQuery detailQuery) {
        return detailQuery.getMemberId() == null;
    }
}

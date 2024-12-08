package com.wanted.backend.market.interfaces;

import com.wanted.backend.market.application.queryservice.GoodsQueryService;
import com.wanted.backend.market.domain.query.GoodsDetailQuery;
import com.wanted.backend.market.domain.view.GoodsDetailView;
import com.wanted.backend.market.domain.view.GoodsView;
import com.wanted.backend.market.interfaces.dto.response.GoodsDetailResponse;
import com.wanted.backend.market.interfaces.dto.response.GoodsListResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.List;

import static com.wanted.backend.market.common.constants.GoodsApiUrl.GOODS_BASE_URL;
import static com.wanted.backend.market.common.constants.ResponseCode.SUCCESS;

@Slf4j
@RestController
@RequestMapping(GOODS_BASE_URL)
@RequiredArgsConstructor
public class GoodsController {

    private final GoodsQueryService goodsQueryService;

    @GetMapping
    public ResponseEntity<GoodsListResponse> getAllGoods() {

        List<GoodsView> goodsViewList = goodsQueryService.findAll();
        return new ResponseEntity<>(new GoodsListResponse(goodsViewList), getSuccessHeader(), HttpStatus.OK);
    }

    @GetMapping("/{goodsId}")
    public ResponseEntity<GoodsDetailResponse> getGoodsDetail(
            @RequestHeader(value = "memberId", required = false) String memberId,
            @NotBlank @PathVariable(value = "goodsId") String goodsId) {

        GoodsDetailView detailView = goodsQueryService.findById(new GoodsDetailQuery(memberId, goodsId));
        return new ResponseEntity<>(new GoodsDetailResponse(detailView), getSuccessHeader(), HttpStatus.OK);
    }


    private HttpHeaders getSuccessHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("resultCode", SUCCESS.getResultCode());
        headers.set("resultMessage", URLEncoder.encode(SUCCESS.getResultMessage()));
        return headers;
    }

}

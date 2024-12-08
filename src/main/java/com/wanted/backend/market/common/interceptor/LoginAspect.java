/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright ⓒ2021 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package com.wanted.backend.market.common.interceptor;

import com.wanted.backend.market.common.constants.ResponseCode;
import com.wanted.backend.market.common.exceptions.ApiException;
import com.wanted.backend.market.domain.aggregate.Member;
import com.wanted.backend.market.domain.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Optional;


@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class LoginAspect {

    private final MemberRepository memberRepository;

    @Before("@annotation(com.wanted.backend.market.common.interceptor.LoginCheck)")
    public void before(JoinPoint joinPoint) {

        HttpServletRequest httpServletRequest = currentRequest();
        String authorization = httpServletRequest.getHeader("Authorization");

        Optional<Member> findMember = memberRepository.findById(Long.valueOf(authorization));

        if (findMember.isEmpty()) throw new ApiException(ResponseCode.NOT_VALID_ID_PASSWORD);

        log.info(">>> 허용된 사용자 입니다.");
    }

    private HttpServletRequest currentRequest() {
        // Use getRequestAttributes because of its return null if none bound
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Optional.ofNullable(servletRequestAttributes).map(ServletRequestAttributes::getRequest).orElse(null);
    }
}
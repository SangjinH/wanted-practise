/*
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Starbucks Coffee Company.
 * Starbucks Coffee Company owns the intellectual property rights in and to this program.
 *
 * (Copyright ⓒ2021 Starbucks Coffee Company. All Rights Reserved | Confidential)
 */

package com.wanted.backend.market.domain.repository;

import com.wanted.backend.market.domain.aggregate.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Override
    Optional<Member> findById(Long aLong);
}

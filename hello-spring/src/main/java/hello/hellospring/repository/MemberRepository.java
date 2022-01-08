package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import hello.hellospring.domain.Member;

public interface MemberRepository {
    Member save(Member member); // 내용이 저장소로 저장됨

    Optional<Member> findById(Long id); // ID값으로 검색

    Optional<Member> findByName(String name); // Name으로 검색

    List<Member> findAll(); // 모든 리스트 반환

}

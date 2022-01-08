package hello.hellospring.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // test가 끝나면 데이터를 clear 해줘야 한다.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));
        // Assertions.assertEquals(result, member);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("현익");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("푸른");
        repository.save(member2);

        Member result = repository.findByName("현익").get();
        Assertions.assertEquals(result, member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("현익");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("푸른");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertEquals(result.size(), 2);
    }
}

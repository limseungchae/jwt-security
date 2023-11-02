package join.login.jwtsecurity.repository;

import join.login.jwtsecurity.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email); // email 일치하는 member 찾아준다
}
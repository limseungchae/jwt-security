package join.login.jwtsecurity.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.management.relation.Role;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 파라미터 없는 생성자 생성
@AllArgsConstructor // 모든 파라미터로 받는 생성자 생성
@Builder // 빌드 메서드 패턴 사용
@Entity
public class Member extends BaseTimeEntity {

    @Id // 프라이머리 키 설정
    @Column(name = "member_id") // 컬럼 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가 생성
    private Long id; // 식별자

    @Column(length = 45, unique = true) // 길이 45, 고유값 = 중복값 허용하지 않는다
    private String email; // 이메일

    @Column(length = 45)
    private String nickname; // 닉네임

    private int age; // 나이

    @Column(length = 100)
    private String password; // 패스워드

    @Enumerated(EnumType.STRING) // Enum 타입 필드를 문자열로 저장
    private Role role; // 역할 (USER, ADMIN, MODERATOR) 타입

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password); // 패스워드 암호화
    }
}
package join.login.jwtsecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import join.login.jwtsecurity.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data //  get/set 자동생성
@Builder // 빌드 메서드 패턴 사용
@AllArgsConstructor // 모든 파라미터로 받는 생성자 생성
public class MemberSignUpRequestDto {

    @NotBlank(message = "아이디를 입력해주세요") // 아이디 필드에 대한 유효성 검사
    private String email;

    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min=2, message = "닉네임이 너무 짧습니다.")  // 닉네임 길이에 대한 유효성 검사
    private String nickname;

    @NotNull(message = "나이를 입력해주세요")
    @Range(min = 0, max = 150) // 나이 범위에 대한 유효성 검사
    private int age;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
/*    ^(?=.*[A-Za-z]): 최소한 1개의 알파벳(대문자 또는 소문자)이 필요합니다. // 비밀번호 패턴에 대한 유효성 검사
            (?=.*\\d): 최소한 1개의 숫자가 필요합니다.
            (?=.*[@$!%*#?&]): 최소한 1개의 특수문자(@, $, !, %, *, #, ? 또는 &)가 필요합니다.
            [A-Za-z\\d@$!%*#?&]{8,30}$: 비밀번호는 8~30자리여야하며, 알파벳, 숫자, 특수문자 중 하나 이상을 포함해야 합니다.*/
    private String password;

    private String checkedPassword; // 비밀번호 확인

    private Member.Role role; // 회원 역할

    @Builder // 빌드 메서드 패턴 사용
    public Member toEntity(){
        return Member.builder()
                .email(email)
                .nickname(nickname)
                .age(age)
                .password(password)
                .role(Member.Role.USER) // 역할은 USER 설정
                .build();
    }
}

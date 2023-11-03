package join.login.jwtsecurity.service;

import join.login.jwtsecurity.dto.MemberSignUpRequestDto;

public interface MemberService {

    // 회원가입
    public Long signUp(MemberSignUpRequestDto requestDto) throws Exception;
}
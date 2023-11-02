package join.login.jwtsecurity.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 엔티티 수정된 시간
@EntityListeners(AuditingEntityListener.class) // 엔티티 수정시간을 추적하고 이력 유지
public class BaseTimeEntity {

    @CreatedDate // 엔티티 생성된 시간
    private LocalDateTime createDate; // LocalDateTime = 엔티티 생성 및 수정 시간

    @LastModifiedDate // 엔티티 수정 시간
    private LocalDateTime modifiedDate;
}
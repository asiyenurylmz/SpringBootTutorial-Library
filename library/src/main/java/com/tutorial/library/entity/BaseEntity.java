package com.tutorial.library.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {
	@CreatedDate
	@Column(name = "created_at")
	LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	LocalDateTime updatedAt;

	@PrePersist
	void prePersist() {
		createdAt = updatedAt = LocalDateTime.now(ZoneId.of("Europe/Istanbul"));
	}

	@PreUpdate
	void preUpdate() {
		updatedAt = LocalDateTime.now(ZoneId.of("Europe/Istanbul"));
	}
}

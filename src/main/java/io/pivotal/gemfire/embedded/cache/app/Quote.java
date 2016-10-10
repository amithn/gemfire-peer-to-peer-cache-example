package io.pivotal.gemfire.embedded.cache.app;

import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("unused")
public class Quote implements Serializable {

	private Long id;
	private String randomName;

	public Quote(Long id, String uuid) {
		this.id = id;
		this.randomName = uuid;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getRandomName() {
		return randomName;
	}

	public void setRandomName(final String randomName) {
		this.randomName = randomName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Quote)) {
			return false;
		}

		Quote that = (Quote) obj;

		return ObjectUtils.nullSafeEquals(this.getId(), that.getId());
	}

	@Override
	public int hashCode() {
		int hashValue = 17;
		hashValue = 37 * hashValue + ObjectUtils.nullSafeHashCode(getId());
		return hashValue;
	}

	@Override
	public String toString() {
		return getRandomName();
	}

}

package io.pivotal.gemfire.embedded.cache.app;

import java.util.HashMap;
import java.util.Map;

import org.kohsuke.randname.RandomNameGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.PostConstruct;

@SuppressWarnings("unused")
public class QuoteService {

	private final RandomNameGenerator randomNameGenerator;
	private Map<Long, String> fakeBackendDataStore = new HashMap<>();
	private volatile boolean cacheMiss = false;

	@Autowired
	public QuoteService(RandomNameGenerator randomNameGenerator) {
		this.randomNameGenerator = randomNameGenerator;
	}

	@PostConstruct
	public void init() {
		for(long i = 0; i < 1000; i++) {
			fakeBackendDataStore.put(i, randomNameGenerator.next());
		}
	}

	/* If this function is called we have a cache miss */
	@Cacheable("Quotes")
	public Quote requestQuote(Long id) {
		weHaveACacheMiss();
		System.out.println("Calling read-through cache for id = " + id);
		String randomName =  fakeBackendDataStore.get(id);
		return new Quote(id, randomName);
	}

	public void weHaveACacheMiss() {
		this.cacheMiss = true;
	}

	public boolean isCacheMiss() {
		return cacheMiss;
	}

	public void setCacheMissStatus(boolean isMissed) {
		this.cacheMiss = isMissed;
	}

}

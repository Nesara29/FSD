package com.cpcjunit.junittest;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoreRepoTest {
	
	@Autowired
	private StoreRepo storerepo;
	
	@Test
	@Order(1)
	@Rollback(value=false)
	public void saveStoreTest() {
		Store store = new Store ("5 High","Mysuru"); 
		storerepo.save(store);
		Assertions.assertThat(store.getSid()).isGreaterThanOrEqualTo(0);
	}
	@Test
	@Order(2)
	public void getStoreTest() {
		List<Store> store = storerepo.findAll();
		Assertions.assertThat(store.size()).isGreaterThan(0);
	}
	@Test
	@Order(3)
	@Rollback
	public void updateStoreTest() {
		Store store = storerepo.findById(1).get();
		store.setSaddress("Mandya");
		Store newStore = storerepo.save(store);
		Assertions.assertThat(newStore.getSaddress()).isEqualTo("Mandya");
	}
	@Test
	@Order(4)
	public void deleteStoreTest() {
		boolean beforeDelete = storerepo.findById(1).isPresent();
		storerepo.deleteById(1);
		boolean afterDelete = storerepo.findById(1).isPresent();
		assertTrue(beforeDelete);
		assertFalse(afterDelete);
	}
	
	}

package com.cpcjunit.junittest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepo extends JpaRepository<Store, Integer> {
	
}

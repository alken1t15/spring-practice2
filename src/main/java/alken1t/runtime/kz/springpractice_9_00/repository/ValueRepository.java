package alken1t.runtime.kz.springpractice_9_00.repository;

import alken1t.shop.entity.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value,Long> {
}
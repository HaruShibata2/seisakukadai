package jp.ac.ohara.seisakukadai.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.seisakukadai.model.Account;



@Repository
public interface AccountRepository  extends JpaRepository<Account,Long>{

	

}

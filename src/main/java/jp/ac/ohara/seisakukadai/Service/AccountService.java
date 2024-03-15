package jp.ac.ohara.seisakukadai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.seisakukadai.model.Account;
import jp.ac.ohara.seisakukadai.repository.AccountRepository;

@Service
@Transactional

public class AccountService {

	@Autowired
	private AccountRepository repository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<AddressBook>
	 */
	public List<Account> getAccountList() {
	    List<Account> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public Account get(@NonNull Long index) {
		Account account = this.repository.findById(index).orElse(new Account());
		return account;
	}

	/**
	 * アドレス帳データの保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull Account account) {
		this.repository.save(account);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.repository.deleteById(index);
	}
}

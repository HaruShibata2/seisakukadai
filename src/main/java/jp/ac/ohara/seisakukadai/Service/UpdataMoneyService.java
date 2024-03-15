package jp.ac.ohara.seisakukadai.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import jp.ac.ohara.seisakukadai.model.UpdateMoneyform;
import jp.ac.ohara.seisakukadai.repository.UpdataMoneyRepository;

@Service
@Transactional

public class UpdataMoneyService {

	@Autowired
	private UpdataMoneyRepository repository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<AddressBook>
	 */
	public List<UpdateMoneyform> getmoneyList() {
	    List<UpdateMoneyform> entityList = this.repository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public UpdateMoneyform get(@NonNull Integer index) {
		UpdateMoneyform money = this.repository.findById(index).orElse(new UpdateMoneyform());
		return money;
	}

	/**
	 * アドレス帳データの保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull UpdateMoneyform money) {
		this.repository.save(money);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Integer index) {
		this.repository.deleteById(index);
	}
}


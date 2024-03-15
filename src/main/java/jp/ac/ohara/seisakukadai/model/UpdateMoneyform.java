package jp.ac.ohara.seisakukadai.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;









@Entity
@Table(name="updata")
public class UpdateMoneyform {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private long id;
	@Column(length = 128, nullable = false)
	private Integer updatamoney;
	

    public Integer getupdatamoney() {
        return updatamoney;
    }
    public void setupdatamoney(Integer updatamoney) {
        this.updatamoney = updatamoney;
    }
}
	

package jp.ac.ohara.seisakukadai.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.ac.ohara.seisakukadai.Service.AccountService;
import jp.ac.ohara.seisakukadai.Service.UpdataMoneyService;
import jp.ac.ohara.seisakukadai.model.Account;
import jp.ac.ohara.seisakukadai.model.UpdateMoneyform;
import jp.ac.ohara.seisakukadai.repository.AccountRepository;
import lombok.NonNull;

@Controller
public class ManiController {
	@Autowired
	private AccountService acocuntService;
	@Autowired
	private UpdataMoneyService moneyService ;

	AccountRepository repository;
  @GetMapping("/add/")
  public String index(Model model) {
    model.addAttribute(model);
    return "base";
    }
  @GetMapping("/")
  public String ModelandView(Account account,Model model) {
    model.addAttribute(model);
    model.addAttribute("Account",account);
    return "account";
    }
  @GetMapping("/postmoney/")
  public String ModelAndView(UpdateMoneyform money,Model model) {
	model.addAttribute(model);
    model.addAttribute("updatamoney",money);
    return "updatamoney";
    }
  @GetMapping("/hyouji/")
	public String index2(Model model) {
	model.addAttribute("list",this.acocuntService.getAccountList());
	//model.addAttribute("list2",this.seisekiService.getSeisekiList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "hyouji1";
	}
  @GetMapping("/update/")
  public String update(Account account ,UpdateMoneyform upMoney) {
	  int updatebank = account.getBlance() ;
	  int updataMoney = upMoney.getupdatamoney();
	  if (updatebank + updataMoney < 0) { 
		  new Exception();
	  }
	  int newBlance = updatebank + updataMoney;
	  return "base";
  }
  @PostMapping("/postaccount/")
  public String account(@Validated @ModelAttribute @NonNull Account account, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
      try {
          this.acocuntService.save(account);
          redirectAttributes.addFlashAttribute("exception", "");
 
      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("exception", e.getMessage());
      }
      return "redirect:/add/";
 
    }
  
 
  
  @PostMapping("/postmoney/")
  public String money(@Validated @ ModelAttribute @NonNull UpdateMoneyform money, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
      try {
          this.moneyService.save(money);
          redirectAttributes.addFlashAttribute("exception", "");
 
      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("exception", e.getMessage());
      }
      return "redirect:/add/";
}
}


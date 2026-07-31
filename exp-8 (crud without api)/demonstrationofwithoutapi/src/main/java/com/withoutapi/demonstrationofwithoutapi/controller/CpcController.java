package com.withoutapi.demonstrationofwithoutapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.withoutapi.demonstrationofwithoutapi.model.Cpc;
import com.withoutapi.demonstrationofwithoutapi.repository.CpcRepo;

@Controller
public class CpcController {

	@Autowired
	CpcRepo cpcrepo;
	
	@RequestMapping("index")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("addCpc")
	public String addCpc(Cpc cpc) {
		cpcrepo.save(cpc);
		return "index.jsp";
	}
	
	@RequestMapping("updCpc")
	public ModelAndView updCpc(Cpc cpc) {
		ModelAndView mv = new ModelAndView("update.jsp");
		cpc = cpcrepo.findById(cpc.getCid()).orElse(new Cpc());
		mv.addObject(cpc);
		return mv;
	}
	
	@RequestMapping("getCpc")
	public ModelAndView getCpc(@RequestParam int cid) {
		ModelAndView mv = new ModelAndView("display.jsp");
		Cpc cpc = cpcrepo.findById(cid).orElse(new Cpc());
		mv.addObject(cpc);
		return mv;
	}
	
	@RequestMapping("delCpc")
	public ModelAndView delCpc(@RequestParam int cid) {
		ModelAndView mv = new ModelAndView("delete.jsp");
		Cpc cpc = cpcrepo.findById(cid).orElse(new Cpc());
		cpcrepo.deleteById(cid);
		mv.addObject(cpc);
		return mv;
	}
}

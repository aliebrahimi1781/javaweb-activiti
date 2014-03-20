package com.haozileung.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haozileung.test.dto.Response;
import com.haozileung.test.pojo.apply.Apply;
import com.haozileung.test.service.IApplyService;

@Controller
@RequestMapping("apply")
public class ApplyController {// extends BaseController<Apply> {

	@Autowired
	private IApplyService applyService;

	@RequestMapping("/add")
	@ResponseBody
	public Response<Apply> saveApply(Apply apply) {
		System.out.println("saving apply");
		Response<Apply> response = new Response<Apply>();
		if (apply != null && apply.getApplier() != null) {
			applyService.startFlow(apply);
			List<Apply> data = new ArrayList<Apply>();
			data.add(apply);
			response.setData(data);
		}

		response.setStatus(0);

		return response;
	}

	public Response<Apply> getApplyList() {
		Response<Apply> response = new Response<Apply>();
		response.setStatus(0);
		return response;
	}
}

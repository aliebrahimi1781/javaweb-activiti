package com.haozileung.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
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

	@Autowired
	protected RuntimeService runtimeService;

	@Autowired
	protected TaskService taskService;

	@RequestMapping("/add")
	@ResponseBody
	public Response<Apply> saveApply(Apply apply) {
		System.out.println("saving apply");
		Response<Apply> response = new Response<Apply>();
		if (apply != null && apply.getApplier() != null) {
			if (applyService.startFlow(apply)) {
				List<Apply> data = new ArrayList<Apply>();
				data.add(apply);
				response.setData(data);
				response.setStatus(0);
				return response;
			}
		}
		response.setStatus(-1);
		return response;
	}

	@RequestMapping("/fetch")
	@ResponseBody
	public Response<Apply> getApplyList(String userId, String type) {
		Response<Apply> response = new Response<Apply>();
		if (userId != null) {
			List<Apply> appliyList = applyService.getToDoApplyList(userId);
			response.setData(appliyList);
			response.setStatus(0);
		}
		if (type != null) {
			List<Apply> appliyList = null;
			if (type.equals("running")) {
				appliyList = applyService.getRunningApplyList();
			}
			if (type.equals("finished")) {
				appliyList = applyService.getFinishedApplyList();
			}
			response.setData(appliyList);
			response.setStatus(0);
		}

		return response;
	}

	@RequestMapping("/update")
	@ResponseBody
	public Response<Apply> updateApply(Apply apply, String userId, String type) {

		Response<Apply> response = new Response<Apply>();
		Map<String, Object> var = new HashMap<String, Object>();
		if (userId.equals("pm") && apply.getResult1() != null) {
			var.put("pmPass", apply.getResult1() == 1 ? true : false);
		}
		if (userId.equals("dm") && apply.getResult2() != null) {
			var.put("dmPass", apply.getResult2() == 1 ? true : false);
		}
		if (type != null) {
			if (userId.equals("Haozi") && type.equals("reApply")) {
				var.put("reApply", true);
				if (applyService.updateApplyComplete(apply, userId, var)) {
					response.setStatus(0);
				} else {
					response.setStatus(-1);
				}
			}
			if (type.equals("claim")) {
				if (applyService.updateApplyClaim(apply, userId)) {
					response.setStatus(0);
				} else {
					response.setStatus(-1);
				}
			}
			if (type.equals("complete")) {
				if (applyService.updateApplyComplete(apply, userId, var)) {
					response.setStatus(0);
				} else {
					response.setStatus(-1);
				}
			}
		} else {
			if (userId.equals("Haozi")) {
				if (applyService.updateApplyComplete(apply, userId, var)) {
					response.setStatus(0);
				} else {
					response.setStatus(-1);
				}
			}
		}
		return response;
	}
}

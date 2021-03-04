package com.frankstar.spring.flowable.controller;

import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author :  frankstar
 * @AddTime :  2020/9/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Controller
@RequestMapping("/leave/")
public class LeaveController {

	@Resource
	private RuntimeService runtimeService;

	@Resource
	private TaskService taskService;

	@RequestMapping(value = "startLeaveProcess")
	@ResponseBody
	public String startLeaveProcess(String staffId) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("leaveTask", staffId);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Leave", map);
		StringBuilder sb = new StringBuilder();
		sb.append("创建请假流程 processId：" + processInstance.getId());
		List<Task> tasks = taskService.createTaskQuery().taskAssignee(staffId).orderByTaskCreateTime().desc().list();
		for (Task task : tasks) {
			sb.append("任务taskId:" + task.getId());
		}
		return sb.toString();
	}
}

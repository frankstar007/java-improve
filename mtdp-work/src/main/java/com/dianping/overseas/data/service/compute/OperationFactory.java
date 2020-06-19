package com.dianping.overseas.data.service.compute;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Component
public class OperationFactory {

	@Resource
	private List<Operation> operationList;


	public Operation getOperation(String opera, double head, double tail) {
		Operation operation = createOperation(opera);
		operation.setHead(head);
		operation.setTail(tail);
		return operation;
	}

	private Operation createOperation(String opera) {
		return operationList.stream().filter(operation -> operation.opera().equals(opera)).findFirst().orElse(null);
	}


}

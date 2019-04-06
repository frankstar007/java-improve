package com.frankstar.java.design.patterns.abstractdocument;

import com.frankstar.java.design.patterns.abstractdocument.domin.Car;
import com.frankstar.java.design.patterns.abstractdocument.domin.HasModel;
import com.frankstar.java.design.patterns.abstractdocument.domin.HasParts;
import com.frankstar.java.design.patterns.abstractdocument.domin.HasPrice;
import com.frankstar.java.design.patterns.abstractdocument.domin.HasType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class App {

	public App() {

	log.info("Constructing parts and car");
	Map<String, Object> carProperties = new HashMap<>();
    carProperties.put(HasModel.PROPERTY, "300SL");
    carProperties.put(HasPrice.PROPERTY, 10000L);

	Map<String, Object> wheelProperties = new HashMap<>();
    wheelProperties.put(HasType.PROPERTY, "wheel");
    wheelProperties.put(HasModel.PROPERTY, "15C");
    wheelProperties.put(HasPrice.PROPERTY, 100L);

	Map<String, Object> doorProperties = new HashMap<>();
    doorProperties.put(HasType.PROPERTY, "door");
    doorProperties.put(HasModel.PROPERTY, "Lambo");
    doorProperties.put(HasPrice.PROPERTY, 300L);

    carProperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

	Car car = new Car(carProperties);

    log.info("Here is our car:");
    log.info("-> model: {}", car.getModel().get());
    log.info("-> price: {}", car.getPrice().get());
    log.info("-> parts: ");
    car.getParts().forEach(p -> log.info("\t{}/{}/{}", p.getType().get(), p.getModel().get(), p.getPrice().get()));
}


	public static void main(String[] args) {
		new App();
	}
}

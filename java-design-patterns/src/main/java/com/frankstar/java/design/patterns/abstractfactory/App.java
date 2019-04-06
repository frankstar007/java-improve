package com.frankstar.java.design.patterns.abstractfactory;

import com.frankstar.java.design.patterns.abstractfactory.App.FactoryMaker.KingdomType;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
@Data
public class App {

	private King king;

	private Castle castle;

	private Army army;

	public void createKingdom(final KingdomFactory kingdomFactory) {
		setKing(kingdomFactory.createKing());
		setArmy(kingdomFactory.createArmy());
		setCastle(kingdomFactory.createCastle());
	}

	King getKing(KingdomFactory kingdomFactory) {
		return kingdomFactory.createKing();
	}

	Army getArmy(KingdomFactory kingdomFactory) {
		return kingdomFactory.createArmy();
	}

	Castle getCastle(KingdomFactory kingdomFactory) {
		return kingdomFactory.createCastle();
	}

	public static class FactoryMaker {

		public enum KingdomType {
			/**
			 * ORC
			 */
			ORC,
			/**
			 * ELF
			 */
			ELF
		}

		public static KingdomFactory makeFactory(KingdomType type) {
			switch (type) {
				case ELF:
					return new ElfKingdomFactory();
				case ORC:
					return new OrcKingdomFactory();
				default:
					throw new IllegalArgumentException("kingdom type not support!");
			}
		}

	}

	public static void main(String[] args) {
		App app = new App();
		log.info("Elf Kingdom");
		app.createKingdom(FactoryMaker.makeFactory(KingdomType.ELF));
		log.info(app.getArmy().getDescription());
		log.info(app.getCastle().getDescription());
		log.info(app.getKing().getDescription());

		log.info("Orc Kingdom");
		app.createKingdom(FactoryMaker.makeFactory(KingdomType.ORC));
		log.info(app.getArmy().getDescription());
		log.info(app.getCastle().getDescription());
		log.info(app.getKing().getDescription());
	}


}

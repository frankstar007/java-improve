package com.frankstar.java.design.patterns.abstractfactory;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class OrcKingdomFactory implements KingdomFactory {

	@Override
	public Castle createCastle() {
		return new OrcCastle();
	}

	@Override
	public King createKing() {
		return new OrcKing();
	}

	@Override
	public Army createArmy() {
		return new OrcArmy();
	}
}

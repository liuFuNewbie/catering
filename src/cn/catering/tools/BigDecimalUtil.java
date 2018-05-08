package cn.catering.tools;

import java.math.BigDecimal;
/**
 * 精确的数据运算
 * @author MDS
 *
 */
public class BigDecimalUtil {
	enum BigDecimalOperations {
		add, subtraction, multiplication, division
	}
	/**
	 * 数据运算
	 * @param numOne 第一个数字
	 * @param numTow 第二个数字
	 * @param operations 采用什么运算符
	 * @param scale 保留小数位
	 * @param roundingMode 舍入模式
	 * @return
	 */
	public BigDecimal operationASMD(Object numOne, Object numTow,
			BigDecimalOperations operations, int scale, int roundingMode) {
		BigDecimal num1 = new BigDecimal(String.valueOf(numOne)).setScale(
				scale, roundingMode);
		BigDecimal num2 = new BigDecimal(String.valueOf(numTow)).setScale(
				scale, roundingMode);
		switch (operations) {
			case add:
				return num1.add(num2).setScale(scale, roundingMode);
			case subtraction:
				return num1.subtract(num2).setScale(scale, roundingMode);
			case multiplication:
				return num1.multiply(num2).setScale(scale, roundingMode);
			case division:
				return num1.divide(num2, scale, roundingMode);
		}
		return null;
	}
}

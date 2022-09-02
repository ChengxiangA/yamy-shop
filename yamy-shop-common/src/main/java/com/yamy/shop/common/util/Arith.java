package com.yamy.shop.common.util;

import java.math.BigDecimal;

/**
 * @author 程祥
 * @date 2022/8/30 11:23
 */
public class Arith {
    /**
     * 运算精度,保留几位小数
     */
    private static final int DEF_DIV_SCALE = 2;

    private Arith() {
    }

    /**
     * 加法
     * 构造BigDecimal实例最好使用 String
     * @param v1
     * @param v2
     * @return
     */
    public static Double add(Double v1,Double v2) {
        return new BigDecimal(v1.toString()).add(new BigDecimal(v2.toString())).doubleValue();
    }

    /**
     * 减法
     * @param v1
     * @param v2
     * @return
     */
    public static Double sub(Double v1,Double v2) {
        return new BigDecimal(v1.toString()).subtract(new BigDecimal(v2.toString())).doubleValue();
    }

    /**
     * 乘法
     * @param v1
     * @param v2
     * @return
     */
    public static Double mul(Double v1,Double v2) {
        return new BigDecimal(v1.toString()).multiply(new BigDecimal(v2.toString())).setScale(Arith.DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。.
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。.
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供精确的小数位四舍五入处理。.
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * @param bigDecimal
     * @param bigDecimal2
     * @param bigDecimal3
     * @return
     */
    public static double add(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        return bigDecimal.add(bigDecimal2).add(bigDecimal3).doubleValue();
    }

    /**
     * @param preDepositPrice
     * @param finalPrice
     * @return
     */
    public static double add(BigDecimal preDepositPrice, BigDecimal finalPrice) {
        return preDepositPrice.add(finalPrice).doubleValue();
    }

}

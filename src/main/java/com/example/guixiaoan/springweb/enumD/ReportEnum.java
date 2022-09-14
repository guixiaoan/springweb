package com.example.guixiaoan.springweb.enumD;

import java.util.EnumSet;

/**
 * 报表枚举
 *
 * @author LIYAO
 * @date 2022/09/08
 */
public enum ReportEnum {

    /**
     * FISP报表
     */
    R004_FISP("R004_FISP"),

    /**
     * 人行报表
     */
    R004_PBOC("R004_FISP"),

    /**
     * 中基协报表
     */
    R004_AMAC("R004_FISP"),

    /**
     * 资管月周报报表
     */
    R004_CUS("R004_FISP"),

    /**
     * 中证协报表
     */
    R004_SAC("R004_FISP"),

    /**
     * 个性化内部报表
     */
    R004_PERSON("R004_FISP"),

    /**
     * 分级基金信息
     */
    R004_FUND("R004_FISP"),

    /**
     * 现金管理
     */
    R004_CASHM("R004_FISP"),

    /**
     * 专项产品
     */
    R004_SPRO("R004_FISP");

    private final String type;

    ReportEnum(String type) {
        this.type = type;
    }

    /**
     * 实现字符串转枚举的静态方法
     *
     * @param type 类型
     * @return {@link ReportEnum}
     */
    public static ReportEnum fromType(String type) {
        if (type == null) {
            return null;
        }
        return EnumSet.allOf(ReportEnum.class).stream()
                .filter(s -> s.toString().equals(type))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid type: " + type));
    }

}

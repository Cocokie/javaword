package com.lix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author CYJ
 * @version 1.0
 * @createtime 2019/12/19
 */

public enum ReturnCode {

    // 系统 状态码规范：00xx
    SUCCESS("0", "成功"), SYSTEM_ERROR("0001", "系统错误"), MULTI_STATUS("0002", "频繁操作"), UNAUTHORIZED("0003", "没有权限"),
    PARAM_ERROR("0004", "传入参数错误"), INVALID_TOKEN("0005", "无效TOKEN"), INVALID_REQUEST_TIME("0006", "无效请求，时间差操作超过6分钟"),
    RESULT_IS_EMPTY("0007", "没有查询到结果"), INVALID_VERIFYCODE("0008", "无效验证码"), NO_DATA_UPDATE("0009", "没有数据更新"), DATA_EXISTS("0010", "数据已存在"), SERVICE_ERROR("0011", "业务异常"),
    INVALID_MOBILE("0012", "请输入11位有效手机号码"),USER_CHANNEL_NOT_RELATION("0014","用户和渠道未关联或者渠道不存在"),
    NOT_FOUND_ERROR("0013","数据未找到"),SHOP_KEEPER_NOT_DEVICE("0015","店主无对应的渠道"),CASH_NOT_THERE_ARE("0016","活动不存在"),
    DETAIL_NOT_THERE_ARE("0017","活动明细不存在"),RECORD_THERE_ARE("0018","记录已存在"),ORDER_IS_NOT_EXISTS("0019","订单不存在"),
    NOT_SHIPPED_SUCCESSFUL("0020","订单出货不成功"),DEVICE_NOT_CASH("0021","设备为配置活动"),REPEAT_DRAW("0022","重复抽奖"),
    NOT_TEMPLATE_DETAIL("0023","未配置活动明细"), LUCKY_DRAW_NOT_THERE_ARE("0024","抽奖记录不存在"), NOT_WINNING("0025","未中奖!奖品不予以发放"),
    ALREADY_ISSUE("0026","奖品已经发放！重复发放！"), ACTIVITY_EXPIRED("0027","活动已过期"),ACTIVITY_DISABLED("0027","活动已禁用"),

    // 系统用户
    INVALID_SYSTEM_USER("0020", "用户不存在"), DISABLE_SYSTEM_USER("0021", "用户已被禁用"), PASSWORD_ERROR("0022", "密码错误"), CURRENT_PASSWORD_ERROR("0023", "当前密码不正确!请重新输入"), PASSWORD_COMMON("0024", "更新密码和当前密码一致,没有更新"),
    NOT_PLATFORM_USER("0025", "没有此平台权限，请联系管理员"),

    //设备异常
    DEVICE_IS_NULL("0010", "设备不存在"),DEVICE_NOT_ONLINE("0011", "设备不在线"),

    //商品异常
    GOODS_IS_NULL("0030", "商品不存在"),DEVICE_PATHNO_GOODS_IS_NULL("0031", "设备对应货到商品不存在"),GOODS_STOCK_INSUFFICIENT("0032", "设备商品库存不足"),
    DEVICE_TEMPLET_GOODS_IS_NULL("0033", "设备模板商品不存在"),

    //用户地址
    HIRD_LOGIN_USER_MEMBER("200001", "用户信息异常"),HIRD_ADDRESS_COUNT_CON("203001", "收货地址已达到20条"), HIRD_WX_ADDRESS_CON("203002", "用户微信地址匹配为空"),
    //分发
    HIRD_ADDR_EXCEPTION_OS("202005", "收货地址信息异常"),
    //发物流
    HIRD_READ_REPORT_EXCEPTION("0085", "物流单导入异常"),HIRD_COMMITAG_ORDER("0086", "订单已计算"),HIRD_NOT_DISPA_ORDER("0087", "订单不能进行打印"),HIRD_NOT_SEND_ORDER("0088", "订单不能确认发货"),
    //订单
    HIRD_COMPENSATE_BIG_ORDER("0089", "赔付金额过大"),HIRD_RETREF_BIG_ORDER("0090", "快递费超出"),HIRD_RETREF_BIG_ORDERTYPE("0091", "赠品订单不可退货退款");

    private String code;
    private String msg;

    ReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


    @Override
    public String toString() {
        return "{\"code\":\"" + getCode() + "\",\"msg\": \"" + getMsg() + "\"}";
    }

    /**
     * 所有的枚举信息
     *
     * @return
     */
    public static List<Map<String, String>> list() {
        ArrayList<Map<String, String>> list = new ArrayList<>();
        for (ReturnCode code : ReturnCode.values()) {
            Map<String, String> m = new HashMap<>();
            m.put("code", code.getCode());
            m.put("msg", code.getMsg());
            list.add(m);
        }
        return list;
    }

}

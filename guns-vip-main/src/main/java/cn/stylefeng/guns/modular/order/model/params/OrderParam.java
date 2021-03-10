package cn.stylefeng.guns.modular.order.model.params;

import lombok.Data;
import cn.stylefeng.roses.kernel.model.validator.BaseValidatingParam;
import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author fengye
 * @since 2020-04-15
 */
@Data
public class OrderParam implements Serializable, BaseValidatingParam {

    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 下单地点
     */
    private String place;

    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 下单用户名称
     */
    private String userName;

    /**
     * 下单用户电话
     */
    private String userPhone;

    @Override
    public String checkParam() {
        return null;
    }

}

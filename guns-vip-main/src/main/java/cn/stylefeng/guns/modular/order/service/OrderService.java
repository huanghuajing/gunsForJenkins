package cn.stylefeng.guns.modular.order.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.model.params.OrderParam;
import cn.stylefeng.guns.modular.order.model.result.OrderResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author fengye
 * @since 2020-04-15
 */
public interface OrderService extends IService<Order> {

    /**
     * 新增
     *
     * @author fengye
     * @Date 2020-04-15
     */
    void add(OrderParam param);

    /**
     * 删除
     *
     * @author fengye
     * @Date 2020-04-15
     */
    void delete(OrderParam param);

    /**
     * 更新
     *
     * @author fengye
     * @Date 2020-04-15
     */
    void update(OrderParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author fengye
     * @Date 2020-04-15
     */
    OrderResult findBySpec(OrderParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author fengye
     * @Date 2020-04-15
     */
    List<OrderResult> findListBySpec(OrderParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author fengye
     * @Date 2020-04-15
     */
     LayuiPageInfo findPageBySpec(OrderParam param);

}

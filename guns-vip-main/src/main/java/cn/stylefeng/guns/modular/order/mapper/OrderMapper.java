package cn.stylefeng.guns.modular.order.mapper;

import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.model.params.OrderParam;
import cn.stylefeng.guns.modular.order.model.result.OrderResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author fengye
 * @since 2020-04-15
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 获取列表
     *
     * @author fengye
     * @Date 2020-04-15
     */
    List<OrderResult> customList(@Param("paramCondition") OrderParam paramCondition);

    /**
     * 获取map列表
     *
     * @author fengye
     * @Date 2020-04-15
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") OrderParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author fengye
     * @Date 2020-04-15
     */
    Page<OrderResult> customPageList(@Param("page") Page page, @Param("paramCondition") OrderParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author fengye
     * @Date 2020-04-15
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") OrderParam paramCondition);

}

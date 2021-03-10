package cn.stylefeng.guns.modular.order.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.mapper.OrderMapper;
import cn.stylefeng.guns.modular.order.model.params.OrderParam;
import cn.stylefeng.guns.modular.order.model.result.OrderResult;
import  cn.stylefeng.guns.modular.order.service.OrderService;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author fengye
 * @since 2020-04-15
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public void add(OrderParam param){
        Order entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(OrderParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(OrderParam param){
        Order oldEntity = getOldEntity(param);
        Order newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public OrderResult findBySpec(OrderParam param){
        return null;
    }

    @Override
    public List<OrderResult> findListBySpec(OrderParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(OrderParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(OrderParam param){
        return param.getId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private Order getOldEntity(OrderParam param) {
        return this.getById(getKey(param));
    }

    private Order getEntity(OrderParam param) {
        Order entity = new Order();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}

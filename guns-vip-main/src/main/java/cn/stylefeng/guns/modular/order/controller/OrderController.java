package cn.stylefeng.guns.modular.order.controller;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.mapper.OrderMapper;
import cn.stylefeng.guns.modular.order.model.params.OrderParam;
import cn.stylefeng.guns.modular.order.service.OrderService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Wrapper;


/**
 * 订单表控制器
 *
 * @author fengye
 * @Date 2020-04-15 14:43:40
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    private String PREFIX = "/order";

    @Autowired
    private OrderService orderService;
    @Autowired(required = false)
    private OrderMapper order;
    /**
     * 跳转到主页面
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/order.html";
    }

    /**
     * 新增页面
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @RequestMapping("/add")
    public String add() {
        return PREFIX + "/order_add.html";
    }

    /**
     * 编辑页面
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @RequestMapping("/edit")
    public String edit() {
        return PREFIX + "/order_edit.html";
    }

    /**
     * 新增接口
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(OrderParam orderParam) {
        this.orderService.add(orderParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(OrderParam orderParam) {
        this.orderService.update(orderParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(OrderParam orderParam) {
        this.orderService.delete(orderParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(OrderParam orderParam) {
        Order detail = this.orderService.getById(orderParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author fengye
     * @Date 2020-04-15
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(OrderParam orderParam) {
        Page<Order> pageOrder= new Page<>(1,2);
        QueryWrapper<Order> queryOrder =new QueryWrapper<>();
        queryOrder.like("goods_name","ss").eq("place","商场A");
       Page<Order> orderLI= order.selectPage(pageOrder, queryOrder);
        System.out.println(orderLI.getRecords());
        System.out.println(123);
        System.out.println(orderLI.getRecords().toString());
        return this.orderService.findPageBySpec(orderParam);
    }

}



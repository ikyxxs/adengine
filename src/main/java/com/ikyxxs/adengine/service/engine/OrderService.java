package com.ikyxxs.adengine.service.engine;

import com.ikyxxs.adengine.domain.entity.OrderDO;

/**
 * 订单服务接口
 *
 * @author 木白
 * @date 2022/05/16
 */
public interface OrderService {

    /**
     * 保存订单
     *
     * @param orderDO 订单
     */
    void saveOrder(OrderDO orderDO);
}

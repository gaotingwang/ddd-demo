package com.gtw.business.service.command.cmd;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gtw.business.common.model.Address;
import lombok.Value;

@Value
public class CreateOrderCommand {
    @Valid
    @NotEmpty(message = "订单项不能为空")
    private List<OrderItemCommand> items;

    @NotNull(message = "订单地址不能为空")
    private Address address;

    @Value
    public class OrderItemCommand {
        @NotBlank(message = "产品ID不能为空")
        private String productId;

        @Min(value = 1, message = "产品数量必须大于0")
        private int count;

        @NotNull(message = "产品单价不能为空")
        private BigDecimal itemPrice;

    }
}

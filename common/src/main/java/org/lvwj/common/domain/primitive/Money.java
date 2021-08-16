package org.lvwj.common.domain.primitive;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * 通用值对象(domain primitive(简称:领域基础类型)): 钱
 *
 * @author lvweijie
 * @date 2021-08-15 11:37
 */
@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Money {
    BigDecimal value;
    Currency currency;


    public static Money create(BigDecimal value, Currency currency) {
        return Money.builder().value(Optional.ofNullable(value).orElse(BigDecimal.ZERO)).currency(currency).build();
    }

    public static Money create(BigDecimal value) {
        final Currency rmb = Currency.create("¥", "RMB", "人名币");
        return create(value,rmb);
    }


    public String withSymbol() {
        return value + currency.getSymbol();
    }

    public String enDesc() {
        return value + currency.getEnName();
    }

    public String chDesc() {
        return value + currency.getChName();
    }

    public Money add(BigDecimal amount) {
        return Money.create(this.value.add(amount), this.getCurrency());
    }

    public Money subtract(BigDecimal amount) {
        return Money.create(this.value.subtract(amount), this.getCurrency());
    }

    public Money add(Money money) throws Exception {
        if (null == money) {
            return this;
        }
        if (!money.getCurrency().equals(this.getCurrency())) {
            throw new Exception("不是相同货币无法计算金额！");
        }
        return Money.create(this.value.add(money.getValue()), this.getCurrency());
    }

    public Money subtract(Money money) throws Exception {
        if (null == money) {
            return this;
        }
        if (!money.getCurrency().equals(this.getCurrency())) {
            throw new Exception("不是相同货币无法计算金额！");
        }
        return Money.create(this.value.subtract(money.getValue()), this.getCurrency());
    }
}

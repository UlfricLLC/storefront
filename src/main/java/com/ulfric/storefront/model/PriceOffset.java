package com.ulfric.storefront.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PriceOffset extends Named {

	public static BigDecimal apply(PriceOffset priceOffset, BigDecimal amount) {
		switch (priceOffset.getType() == null ? PriceOffsetType.PERCENTAGE : priceOffset.getType()) {
			case AMOUNT:
				return amount.subtract(priceOffset.getAmount()).setScale(2, RoundingMode.HALF_UP).max(BigDecimal.ZERO);

			case PERCENTAGE:
			default:
				return amount.subtract(amount.multiply(priceOffset.getAmount().divide(BigDecimal.valueOf(100)))).setScale(2, RoundingMode.HALF_UP);
		}
	}

	private PriceOffsetType type;
	private BigDecimal amount;

	public PriceOffsetType getType() {
		return type;
	}

	public void setType(PriceOffsetType type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}

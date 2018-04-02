package com.ulfric.storefront.model;

import java.math.BigDecimal;

public class PriceOffset extends Named {

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

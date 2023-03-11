package org.gvamosi.microservicesexample.web;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Account DTO - used to interact with the {@link WebAccountsService}.
 * 
 * @author Paul Chapman, Gergely Vamosi
 */
@JsonRootName("Account")
public class Account {

	protected UUID id;
	protected String number;
	protected String owner;
	protected BigDecimal balance;

	/**
	 * Default constructor for JPA only.
	 */
	protected Account() {
		balance = BigDecimal.ZERO;
	}

	public UUID getId() {
		return id;
	}

	/**
	 * Set JPA id - for testing and JPA only. Not intended for normal use.
	 * 
	 * @param id
	 *            The new id.
	 */
	protected void setId(UUID id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	protected void setNumber(String accountNumber) {
		this.number = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	protected void setOwner(String owner) {
		this.owner = owner;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	protected void setBalance(BigDecimal value) {
		balance = value;
	}

	@Override
	public String toString() {
    return "Account [id=" + id + ", number=" + number + " [" + owner + "] $" + balance + "]";
	}

}

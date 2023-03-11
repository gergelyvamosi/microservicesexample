package org.gvamosi.microservicesexample.microservices.models;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author Paul Chapman, Gergely Vamosi
 */
@Table
public class Account {

  @PrimaryKey
  private UUID id;

  protected BigDecimal balance;

  protected String number;

	protected String owner;

	/**
	 * Default constructor.
	 */
	protected Account() {
		balance = BigDecimal.ZERO;
	}

  public Account(UUID id, String number, String owner, BigDecimal balance) {
    this.id = id;
		this.number = number;
		this.owner = owner;
		this.balance = balance;
	}

	public Account(UUID id, String number, String owner) {
    this.id = id;
		this.number = number;
		this.owner = owner;
		balance = BigDecimal.ZERO;
	}

	public UUID getId() {
		return id;
	}

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

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

	@Override
	public String toString() {
    return "Account [id=" + id + ", number=" + number + " [" + owner + "] $" + balance + "]";
	}

}

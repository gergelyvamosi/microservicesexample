package org.gvamosi.microservicesexample.microservices.repositories;

import java.util.List;
import java.util.UUID;

import org.gvamosi.microservicesexample.microservices.models.Account;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

/**
 * @author Paul Chapman, Gergely Vamosi
 */
public interface AccountsRepository extends CassandraRepository<Account, UUID> {

  @AllowFiltering
  public Account findByNumber(String accountNumber);

  @AllowFiltering
  public List<Account> findByOwnerContainingIgnoreCase(String partialName);

  @Query("SELECT count(*) from Account")
  public int countAccounts();
}

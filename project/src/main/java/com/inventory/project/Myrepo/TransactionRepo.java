package com.inventory.project.Myrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.project.Entity.Transaction;


@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Integer>
{

}

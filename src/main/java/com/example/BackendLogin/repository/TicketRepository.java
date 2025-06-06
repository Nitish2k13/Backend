package com.example.BackendLogin.repository;

import com.example.BackendLogin.model.CreateTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TicketRepository extends MongoRepository<CreateTicket, String>{
}

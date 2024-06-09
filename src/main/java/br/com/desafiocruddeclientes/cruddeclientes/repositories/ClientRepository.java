package br.com.desafiocruddeclientes.cruddeclientes.repositories;

import br.com.desafiocruddeclientes.cruddeclientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}

package br.com.desafiocruddeclientes.cruddeclientes.services;

import br.com.desafiocruddeclientes.cruddeclientes.dto.ClientDTO;
import br.com.desafiocruddeclientes.cruddeclientes.entities.Client;
import br.com.desafiocruddeclientes.cruddeclientes.repositories.ClientRepository;
import br.com.desafiocruddeclientes.cruddeclientes.services.exceptions.DatabaseException;
import br.com.desafiocruddeclientes.cruddeclientes.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  @Transactional(readOnly = true)
  public ClientDTO findById(Long id) {
    Client client = repository
      .findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado")
      );
    return new ClientDTO(client);
  }

  @Transactional(readOnly = true)
  public Page<ClientDTO> findAll(Pageable pageable) {
    Page<Client> result = repository.findAll(pageable);
    return result.map(x -> new ClientDTO(x));
  }

  @Transactional
  public ClientDTO insert(ClientDTO dto) {
    Client entity = new Client();
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);

    return new ClientDTO(entity);
  }

  @Transactional
  public ClientDTO update(Long id, ClientDTO dto) {
    try {
      Client entity = repository.getReferenceById(id);
      copyDtoToEntity(dto, entity);
      entity = repository.save(entity);

      return new ClientDTO(entity);
    } catch (EntityNotFoundException e) {
      throw new ResourceNotFoundException("Recurso não encontrado");
    }
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void delete(Long id) {
    if (!repository.existsById(id)) {
      throw new ResourceNotFoundException("Recurso não encontrado");
    }
    try {
      repository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException("Falha de integridade referencial");
    }
  }

  private void copyDtoToEntity(ClientDTO dto, Client entity) {
    entity.setName(dto.getName());
    entity.setCpf(dto.getCpf());
    entity.setIncome(dto.getIncome());
    entity.setBirthDate(dto.getBirthDate());
    entity.setChildren(dto.getChildren());
  }
}

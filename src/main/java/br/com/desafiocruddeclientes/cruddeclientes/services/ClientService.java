package br.com.desafiocruddeclientes.cruddeclientes.services;

import br.com.desafiocruddeclientes.cruddeclientes.dto.ClientDTO;
import br.com.desafiocruddeclientes.cruddeclientes.entities.Client;
import br.com.desafiocruddeclientes.cruddeclientes.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository repository;

  @Transactional(readOnly = true)
  public ClientDTO findById(Long id) {
    Client cliente = repository.findById(id).get();
    return new ClientDTO(cliente);
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
    Client entity = repository.getReferenceById(id);
    copyDtoToEntity(dto, entity);
    entity = repository.save(entity);

    return new ClientDTO(entity);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  private void copyDtoToEntity(ClientDTO dto, Client entity) {
    entity.setName(dto.getName());
    entity.setCpf(dto.getCpf());
    entity.setIncome(dto.getIncome());
    entity.setBirthDate(dto.getBirthDate());
    entity.setChildren(dto.getChildren());
  }
}

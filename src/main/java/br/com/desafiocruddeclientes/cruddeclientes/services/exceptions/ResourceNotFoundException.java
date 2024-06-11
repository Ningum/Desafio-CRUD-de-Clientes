package br.com.desafiocruddeclientes.cruddeclientes.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String msg) {
    super(msg);
  }
}

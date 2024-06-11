package br.com.desafiocruddeclientes.cruddeclientes.services.exceptions;

public class DatabaseException extends RuntimeException {

  public DatabaseException(String msg) {
    super(msg);
  }
}

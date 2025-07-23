package br.com.project.airport.seguranca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AgenteSeguranca {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private String idAgente;

   private String nome;

   public AgenteSeguranca() {
   }

   public AgenteSeguranca(String idAgente, String nome) {
      this.idAgente = idAgente;
      this.nome = nome;
   }

   public String getIdAgente() {
      return idAgente;
   }

   public void setIdAgente(String idAgente) {
      this.idAgente = idAgente;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }
}

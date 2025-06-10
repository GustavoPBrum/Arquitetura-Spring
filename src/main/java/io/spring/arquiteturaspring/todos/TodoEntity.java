package io.spring.arquiteturaspring.todos;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_todo")
public class TodoEntity {

    @Id
    @Column(name = "id")  // Este nome esta apenas para fins didaticos, pois nao precisa (quando o nome da coluna eh o mesmo da var)
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Campos de autoincremento
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "concluido")
    private Boolean concluido;  // Caso seja 'boolean' primitivo, pode dar erro se ele for nulo e tentarmos acessa-lo (usamos o wrapper)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluido() {
        return concluido;
    }

    public void setConcluido(Boolean concluido) {
        this.concluido = concluido;
    }
}

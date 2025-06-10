package io.spring.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        return this.service.salvar(todo);
    }

    @PutMapping("{id}")
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity){
        todoEntity.setId(id);  // Se salvar sem Id, vai salvar como outro obj

        service.atualizarStatus(todoEntity);
    }

    @GetMapping("{id}")
    public TodoEntity buscarPorId(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }
}

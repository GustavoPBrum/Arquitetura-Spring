package io.spring.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService service;

    public TodoController(TodoService service) {  // Controller Injeta o service[...] para acessar a logica de negocio
        this.service = service;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity todo) {
        return service.salvar(todo);
    }

    @PutMapping("{id}")        // Vai passar o id da URL pro id,  vai vir o objt Entity no corpo da requisicao sem id
    public void atualizarStatus(@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity){
        todoEntity.setId(id);  // Por isso setamos o id (recebido da URL) aqui em baixo para apenas atualizar o obj e nao salvar um novo

        service.atualizarStatus(todoEntity);
    }

    @GetMapping("{id}")
    public TodoEntity buscarPorId(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }
}

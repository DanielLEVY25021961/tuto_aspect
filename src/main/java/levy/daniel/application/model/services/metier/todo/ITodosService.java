package levy.daniel.application.model.services.metier.todo;


import java.util.Collection;

import levy.daniel.application.model.metier.todo.Todo;

/**
 * Manage Todos.
 * 
 * @author Julien Dubois
 */
public interface ITodosService {

    /**
     * Find a Todo by ID.
     * 
     * @param todoId
     *            The Todo ID
     * @return Todo
     */
    Todo findTodo(String todoId);

    
    /**
     * Create a collection containing all the urgent Todos of the current user.
     * 
     * @return The urgent Todos of the current user
     */
    Collection<Todo> findUrgentTodos();

    /**
     * Create a collection containing all the Todos assigned to the current
     * user.
     * 
     * @return The urgent Todos of the current user
     */
    Collection<Todo> findAssignedTodos();

    
    /**
     * Create a new Todo.
     * 
     * @param listId
     *            The ID of the Todo List to which the Todo belongs
     * @param todo
     *            The Todo to create
     */
    void createTodo(String listId, Todo todo);

    
    /**
     * Delete a Todo.
     * 
     * @param todo The Todo to delete
     */
    void deleteTodo(Todo todo);

    
    /**
     * Delete all the completed Todos of a given list.
     * 
     * @param listId
     *            The list ID
     */
    void deleteAllCompletedTodos(String listId);

    
    /**
     * Complete a Todo.
     * 
     * @param todoId
     *            The ID of the todo
     * @return Todo
     */
    Todo completeTodo(String todoId);

    
    
    /**
     * Re-open a Todo.
     * 
     * @param todoId
     *            The ID of the todo
     * @return Todo
     */
    Todo reopenTodo(String todoId);

    
    /**
     * Updates a todo
     *
     * @param todo The todo to update
     */
    void updateTodo(Todo todo);
    
    
}

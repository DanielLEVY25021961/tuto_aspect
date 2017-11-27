package levy.daniel.application.model.metier.todo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import levy.daniel.application.model.metier.todolist.TodoList;
import levy.daniel.application.model.metier.user.useratodolists.User;




/**
 * class Todo :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 27 nov. 2017
 *
 */
@Entity(name="Todo")
@Table(name = "TODOS")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Todo implements Serializable, Comparable<Todo> {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = 4048798961366546485L;

    
    /**
     * todoId : String :<br/>
     * ID en base.<br/>
     */
    @Id
    @Column(name = "TODO_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String todoId;

    
    /**
     * todoList : TodoList :<br/>
     * TodoList à laquelle appartient le présent Todo.<br/>
     */
    @ManyToOne
    private TodoList todoList;

   
    /**
     * creationDate : Date :<br/>
     * .<br/>
     */
    private Date creationDate;

       
    /**
     * description : String :<br/>
     * .<br/>
     */
    private String description;

       
    /**
     * priority : int :<br/>
     * .<br/>
     */
    private int priority;

       
    /**
     * completed : boolean :<br/>
     * .<br/>
     */
    private boolean completed;

    
    /**
     * completionDate : Date :<br/>
     * .<br/>
     */
    private Date completionDate;

    
    /**
     * dueDate : Date :<br/>
     * .<br/>
     */
    private Date dueDate;

    
    /**
     * assignedUser : User :<br/>
     * .<br/>
     */
    @ManyToOne
    private User assignedUser;

    
    
    /**
     * The length of this field is 10000, which is OK with MySQL but which will
     * cause trouble with other databases (Oracle is limited at 4000 characters,
     * SQL Server at 8000).
     */
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 10000)
    private String notes;

    
    /**
     * hasNotes : boolean :<br/>
     * .<br/>
     */
    private boolean hasNotes;

    
    
    /**
     * method getTodoId() :<br/>
     * Getter de ID en base.<br/>
     * <br/>
     *
     * @return : String : this.todoId.<br/>
     */
    public String getTodoId() {
        return this.todoId;
    } // Fin de getTodoId()._______________________________________________

    
    
    /**
     * method setTodoId(
     * pTodoId) :<br/>
     * Setter de ID en base.<br/>
     * <br/>
     *
     * @param pTodoId : String : valeur à passer à this.todoId.<br/>
     */
    public void setTodoId(
    		final String pTodoId) {
        this.todoId = pTodoId;
    } // Fin de setTodoId(...).____________________________________________

    
    
    /**
     * method getTodoList() :<br/>
     * Getter de la TodoList à laquelle appartient le présent Todo.<br/>
     * <br/>
     *
     * @return : TodoList : this.todoList.<br/>
     */
    public TodoList getTodoList() {
        return this.todoList;
    } // Fin de getTodoList()._____________________________________________

    
    
    /**
     * method setTodoList(
     * TodoList pTodoList) :<br/>
     * SGetter de la TodoList à laquelle appartient le présent Todo.<br/>
     * <br/>
     *
     * @param pTodoList : TodoList : valeur à passer à this.todoList.<br/>
     */
    public void setTodoList(
    		final TodoList pTodoList) {
        this.todoList = pTodoList;
    } // Fin de setTodoList(...).__________________________________________

    
    
    /**
     * method isCompleted() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public boolean isCompleted() {
        return this.completed;
    }


    
    /**
     * method setCompleted() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pCompleted :  :  .<br/>
     */
    public void setCompleted(
    		final boolean pCompleted) {
        this.completed = pCompleted;
    }

    
    
    /**
     * method getCompletionDate() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public Date getCompletionDate() {
        return this.completionDate;
    }

    
    
    /**
     * method setCompletionDate() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pCompletionDate :  :  .<br/>
     */
    public void setCompletionDate(Date pCompletionDate) {
        this.completionDate = pCompletionDate;
    }

    
    
    /**
     * method getCreationDate() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    
    
    /**
     * method setCreationDate() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pCreationDate :  :  .<br/>
     */
    public void setCreationDate(
    		final Date pCreationDate) {
        this.creationDate = pCreationDate;
    }

    
    
    /**
     * method getDescription() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public String getDescription() {
        return this.description;
    }

    
    
    /**
     * method setDescription() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pDescription :  :  .<br/>
     */
    public void setDescription(
    		final String pDescription) {
        this.description = pDescription;
    }

    
    
    /**
     * method getDueDate() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public Date getDueDate() {
        return this.dueDate;
    }

    
    
    /**
     * method setDueDate() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pDueDate :  :  .<br/>
     */
    public void setDueDate(
    		final Date pDueDate) {
        this.dueDate = pDueDate;
    }

    
    
    /**
     * method getPriority() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public int getPriority() {
        return this.priority;
    }

    
    
    /**
     * method setPriority() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pPriority :  :  .<br/>
     */
    public void setPriority(
    		final int pPriority) {
        this.priority = pPriority;
    }

    
    
    /**
     * method getAssignedUser() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public User getAssignedUser() {
        return this.assignedUser;
    }

    
    
    /**
     * method setAssignedUser() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pAssignedUser :  :  .<br/>
     */
    public void setAssignedUser(
    		final User pAssignedUser) {
        this.assignedUser = pAssignedUser;
    }

    
    
    /**
     * method isHasNotes() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public boolean isHasNotes() {
        return this.hasNotes;
    }

    
    
    /**
     * method setHasNotes() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pHasNotes :  :  .<br/>
     */
    public void setHasNotes(
    		final boolean pHasNotes) {
        this.hasNotes = pHasNotes;
    }

    
    
    /**
     * method getNotes() :<br/>
     * .<br/>
     * <br/>
     *
     * @return :  :  .<br/>
     */
    public String getNotes() {
        return this.notes;
    }

    
    
    /**
     * method setNotes() :<br/>
     * .<br/>
     * <br/>
     *
     * @param pNotes :  :  .<br/>
     */
    public void setNotes(
    		final String pNotes) {
        this.notes = pNotes;
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(
    		final Todo pOther) {
    	
        int order = pOther.getPriority() - this.getPriority();
        
        if (this.isCompleted()) {
            order += 10000;
        }
        if (pOther.isCompleted()) {
            order -= 10000;
        }
        if (order == 0) {
            order = (this.getDescription() + this.getTodoId()).compareTo(pOther
                    .getDescription()
                    + pOther.getTodoId());
        }
        return order;
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object pObjet) {
    	
        if (this == pObjet) {
        	return true;
        }
        
        if (pObjet == null || getClass() != pObjet.getClass()) {
        	return false;
        }

        final Todo other = (Todo) pObjet;

        if (this.todoId != null ? 
        		!this.todoId.equals(other.getTodoId()) :
        			other.getTodoId() != null) {
        	return false;
        }

        return true;
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return this.todoId != null ? this.todoId.hashCode() : 0;
    }

    
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Todo{" +
                "this.todoId='" + this.todoId + '\'' +
                ", this.todoList=" + this.todoList.getListId() +
                ", this.description='" + this.description + '\'' +
                '}';
    }
    
    
}

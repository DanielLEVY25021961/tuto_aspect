package levy.daniel.application.model.metier.todo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;



/**
 * class TodoTest :<br/>
 * Test JUnit de la classe Todo.<br/>
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
public class TodoTest {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(TodoTest.class);
	

	// *************************METHODES************************************/
	
	 /**
	 * method CONSTRUCTEUR TodoTest() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public TodoTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	

	@Test
	public void test() {
		fail("Not yet implemented");
	}


	
    /**
     * method testCompareTo() :<br/>
     * .<br/>
     * <br/>
     */
    @Test
    public void testCompareTo() {
    	
        final Todo todo1 = new Todo();
        todo1.setTodoId("01");
        todo1.setCompleted(false);
        todo1.setDescription("Description");
        todo1.setPriority(0);

        final Todo todo2 = new Todo();
        todo2.setTodoId("02");
        todo2.setCompleted(true);
        todo2.setDescription("Description");
        todo2.setPriority(0);

        final Todo todo3 = new Todo();
        todo3.setTodoId("03");
        todo3.setCompleted(false);
        todo3.setDescription("Description");
        todo3.setPriority(10);

        final Todo todo4 = new Todo();
        todo4.setTodoId("04");
        todo4.setCompleted(false);
        todo4.setDescription("AA");
        todo4.setPriority(10);

        final Todo todo5 = new Todo();
        todo5.setTodoId("05");
        todo5.setCompleted(true);
        todo5.setDescription("Description");
        todo5.setPriority(10);

        final Todo todo6 = new Todo();
        todo6.setTodoId("06");
        todo6.setCompleted(false);
        todo6.setDescription("Description");
        todo6.setPriority(10);

        Collection<Todo> sortedTodos = new TreeSet<Todo>();
        sortedTodos.add(todo2);
        sortedTodos.add(todo6);
        sortedTodos.add(todo4);
        sortedTodos.add(todo1);
        sortedTodos.add(todo5);
        sortedTodos.add(todo3);

        assertEquals(6, sortedTodos.size());
        Iterator<Todo> iterator = sortedTodos.iterator();

        Todo testTodo = iterator.next();
        assertEquals("04", testTodo.getTodoId());
        testTodo = iterator.next();
        assertEquals("03", testTodo.getTodoId());
        testTodo = iterator.next();
        assertEquals("06", testTodo.getTodoId());
        testTodo = iterator.next();
        assertEquals("01", testTodo.getTodoId());
        testTodo = iterator.next();
        assertEquals("05", testTodo.getTodoId());
        testTodo = iterator.next();
        assertEquals("02", testTodo.getTodoId());
        
    } // Fin de testCompareTo().___________________________________________


    
    /**
     * method testEquals() :<br/>
     * .<br/>
     * <br/>
     */
    @Test
    public void testEquals() {
    	
        final Todo todo1 = new Todo();
        todo1.setTodoId("001");

        final Todo todo2 = new Todo();
        todo2.setTodoId("001");

        assertEquals(todo1, todo2);

        final Todo todo3 = new Todo();
        todo3.setTodoId("003");

        assertNotSame(todo1, todo3);
        
    } // Fin de testEquals().______________________________________________
    


} // FIN DE LA CLASSE TodoTest.----------------------------------------------

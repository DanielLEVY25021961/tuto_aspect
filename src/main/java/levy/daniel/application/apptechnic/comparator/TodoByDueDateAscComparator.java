package levy.daniel.application.apptechnic.comparator;



import java.util.Comparator;

import levy.daniel.application.model.metier.todo.Todo;

/**
 * Comparator used to sort todos by their due date, in ascending order.
 * 
 * @author Julien Dubois
 */
public class TodoByDueDateAscComparator implements Comparator<Todo> {

    /**
     * {@inheritDoc}
     */
    @Override
	public int compare(Todo first, Todo second) {
        if (first.isCompleted() && !second.isCompleted()) {
            return 1;
        } else if (!first.isCompleted() && second.isCompleted()) {
            return -1;
        }
        int order = 0;
        if (second.getDueDate() == null && first.getDueDate() != null) {
            return 1;
        } else if (second.getDueDate() != null && first.getDueDate() == null) {
            return -1;
        } else if (second.getDueDate() != null && first.getDueDate() != null) {
            long compare = second.getDueDate().getTime()
                    - first.getDueDate().getTime();
            if (compare > 0) {
                order = 1;
            } else if (compare < 0) {
                order = -1;
            }
        }
        if (order == 0) {
            order = second.compareTo(first);
        }
        return order;
    }
}

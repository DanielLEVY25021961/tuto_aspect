package levy.daniel.application.apptechnic.comparator;



import java.util.Comparator;

import levy.daniel.application.model.metier.todo.Todo;

/**
 * Comparator used to sort todos by their description.
 * 
 * @author Julien Dubois
 */
public class TodoByDescriptionComparator implements Comparator<Todo> {

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
        int order;
        order = first.getDescription().toLowerCase().compareTo(
                second.getDescription().toLowerCase());

        if (order == 0) {
            order = first.compareTo(second);
        }
        return order;
    }
}

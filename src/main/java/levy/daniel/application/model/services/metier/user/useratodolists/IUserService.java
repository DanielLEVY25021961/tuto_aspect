package levy.daniel.application.model.services.metier.user.useratodolists;



import java.util.List;

import levy.daniel.application.model.metier.user.useratodolists.User;

/**
 * Manage the security: user authentification and autorizations.
 * 
 * @author Julien Dubois
 */
public interface IUserService {

    /**
     * Get the number of users.
     * @return long
     */
    long getNumberOfUsers();

    
    
    /**
     * Find a user by login.
     * 
     * @param login
     *            The user login
     * @return The user value object
     */
    User findUser(String login);

    
    /**
     * Find all users with a login starting with the "loginStart" string.
     * 
     * @param loginStart 
     * @return List<User>
     */
    List<User> findUsersByLogin(String loginStart);

    
    /**
     * Find the current user.
     * <p>
     * This method relies on Acegy Security.
     * </p>
     * 
     * @return The current user.
     */
    User getCurrentUser();

    
    /**
     * Update a user's information.
     *
     * @param user
     *            The user to update
     */
    void updateUser(User user);

    
    /**
     * Enable a user account.
     * 
     * @param login
     *            The user login
     */
    void enableUser(String login);

    
    /**
     * Disable a user account.
     * 
     * @param login
     *            The user login
     */
    void disableUser(String login);

    
    /**
     * Create a new user.
     * 
     * @param user
     *            The user to create
     *            
     * @throws UserAlreadyExistsException 
     */
    void createUser(User user) throws UserAlreadyExistsException;

    
    /**
     * Send a user's password by email.
     * 
     * @param user
     *            The user
     */
    void sendPassword(User user);
    
    
}

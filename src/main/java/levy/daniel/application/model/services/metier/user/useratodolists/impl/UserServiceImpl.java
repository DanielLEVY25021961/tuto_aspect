package levy.daniel.application.model.services.metier.user.useratodolists.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.apptechnic.property.Property;
import levy.daniel.application.model.metier.todo.Todo;
import levy.daniel.application.model.metier.todolist.TodoList;
import levy.daniel.application.model.metier.user.useratodolists.Role;
import levy.daniel.application.model.metier.user.useratodolists.RolesEnum;
import levy.daniel.application.model.metier.user.useratodolists.User;
import levy.daniel.application.model.services.metier.user.useratodolists.UserAlreadyExistsException;
import levy.daniel.application.model.services.metier.user.useratodolists.IUserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * class UserServiceImpl :<br/>
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
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
    /**
     * US-style date format.
     */
    public static final String DATEFORMAT_US = "MM/dd/yyyy";


    /**
     * log : Log :<br/>
     * .<br/>
     */
    private final Log log = LogFactory.getLog(UserServiceImpl.class);


    /**
     * entityManager : EntityManager :<br/>
     * .<br/>
     */
    @PersistenceContext
    private EntityManager entityManager;

    
        
    /**
     * {@inheritDoc}
     */
    @Override
    public void createUser(
    		final User user) 
    		throws UserAlreadyExistsException {
    	
        if (this.log.isDebugEnabled()) {
            this.log.debug("Creating user '" + user.getLogin() + "'.");
        }

        final User testUser 
        	= this.entityManager.find(User.class, user.getLogin());
        
        if (testUser != null) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("User login '" + user.getLogin()
                        + "' already exists.");
            }
            
            throw new UserAlreadyExistsException("User already exists.");
        }
        
        user.setEnabled(true);
        Date now = Calendar.getInstance().getTime();
        user.setCreationDate(now);
        user.setLastAccessDate(now);
        user.setDateFormat(DATEFORMAT_US);
        
        final Role role = this.entityManager.find(Role.class, RolesEnum.ROLE_USER.name());
        user.getRoles().add(role);
        this.entityManager.persist(user);

        final TodoList todoList = new TodoList();
        
        todoList.setName("Welcome!");
        todoList.setLastUpdate(Calendar.getInstance().getTime());
        this.entityManager.persist(todoList);
        user.getTodoLists().add(todoList);
        todoList.getUsers().add(user);

        final Todo welcomeTodo = new Todo();
        welcomeTodo.setDescription("Welcome to Tudu Lists!");
        welcomeTodo.setPriority(100);
        welcomeTodo.setCreationDate(now);
        welcomeTodo.setCompletionDate(now);
        welcomeTodo.setTodoList(todoList);
        todoList.getTodos().add(welcomeTodo);
        this.entityManager.persist(welcomeTodo);
        if (this.log.isDebugEnabled()) {
            this.log.debug("User '" + user.getLogin() + "' successfully created.");
        }
        
    } // Fin de createUser(...).___________________________________________


    
    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public long getNumberOfUsers() {
        Query query = this.entityManager.createNamedQuery("User.getNumberOfUsers");
        return (Long) query.getSingleResult();
    }


    
   
    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public User findUser(
    		final String login) {
        User user = this.entityManager.find(User.class, login);
        if (user == null) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Could not find User ID=" + login);
            }
            throw new ObjectRetrievalFailureException(User.class, login);
        }
        if (this.log.isDebugEnabled()) {
            this.log.debug("User ID=" + login + " found, user is called "
                    + user.getFirstName() + " " + user.getLastName());
        }
        return user;
    }


    
    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public List<User> findUsersByLogin(
    		final String loginStart) {
        Query query = this.entityManager.createNamedQuery("User.findUsersByLogin");
        query.setParameter("login", loginStart + "%");
        query.setMaxResults(200);
        List<User> users = query.getResultList();
        return users;
    }

    
 
    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public User getCurrentUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        org.springframework.security.core.userdetails.User springSecurityUser = (org.springframework.security.core.userdetails.User) securityContext
                .getAuthentication().getPrincipal();

        return this.findUser(springSecurityUser.getUsername());
    }

    
    
 
    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(
    		final User user) {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Updating user '" + user.getLogin() + "'.");
        }
        this.entityManager.merge(user);
    }

    
    
    /**
     * Enable a user account.
     *
     * @param login The user login
     */
    @Override
    public void enableUser(
    		final String login) {
        User user = this.findUser(login);
        user.setEnabled(true);
    }


    
    /**
     * {@inheritDoc}
     */
    @Override
    public void disableUser(
    		final String login) {
        User user = this.findUser(login);
        user.setEnabled(false);
    }

    
    

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true)
    @Override
    public void sendPassword(
    		final User user) {
    	
        if (this.log.isDebugEnabled()) {
            this.log.debug("Send password of user '" + user.getLogin() + "'.");
        }
        
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        Property smtpHost = this.entityManager.find(Property.class, "smtp.host");
        sender.setHost(smtpHost.getValue());
        Property smtpPort = this.entityManager.find(Property.class, "smtp.port");
        int port = 25;
        try {
            port = Integer.parseInt(smtpPort.getValue());
        } catch (NumberFormatException e) {
            this.log.error("The supplied SMTP port is not a number.");
        }
        sender.setPort(port);
        Property smtpUser = this.entityManager.find(Property.class, "smtp.user");
        sender.setUsername(smtpUser.getValue());
        Property smtpPassword = this.entityManager.find(Property.class, "smtp.password");
        sender.setPassword(smtpPassword.getValue());

        SimpleMailMessage message = new SimpleMailMessage();
        Property smtpFrom = this.entityManager.find(Property.class, "smtp.from");
        message.setTo(user.getEmail());
        message.setFrom(smtpFrom.getValue());
        message.setSubject("Your Tudu Lists password");
        message
                .setText("Dear "
                        + user.getFirstName()
                        + " "
                        + user.getLastName()
                        + ",\n\n"
                        + "Your Tudu Lists password is \""
                        + user.getPassword()
                        + "\".\n"
                        + "Now that this password has been sent by e-mail, we recommend that "
                        + "you change it as soon as possible.\n\n"
                        + "Regards,\n\n" + "Tudu Lists.");

        sender.send(message);
        
    } // Fin de sendPassword(...)._________________________________________
    
    
    
} // FIN DE LA CLASSE UserServiceImpl.---------------------------------------

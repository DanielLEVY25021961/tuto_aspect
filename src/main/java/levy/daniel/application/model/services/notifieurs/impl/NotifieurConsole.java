package levy.daniel.application.model.services.notifieurs.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.services.notifieurs.IMessage;
import levy.daniel.application.model.services.notifieurs.INotifieur;

/**
 * class NotifieurConsole :<br/>
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
public class NotifieurConsole implements INotifieur {

	// ************************ATTRIBUTS************************************/

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(NotifieurConsole.class);

	
	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR NotifieurConsole() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public NotifieurConsole() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifier(
			IMessage pMessage) {
		
		if (pMessage == null) {
			System.out.println("MESSAGE NULL");
		}
		else {
			System.out.println(pMessage.toString());
		}
		
	} // Fin de notifier(...)._____________________________________________


	
} // FIN DE LA CLASSE NotifieurConsole.--------------------------------------

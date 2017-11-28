package levy.daniel.application.aspects.notifieurs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Aspect;

import levy.daniel.application.model.services.notifieurs.INotifieur;

/**
 * class NotifieurAdvice :<br/>
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
@Aspect
public class NotifieurAdvice {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * notifieur : INotifieur :<br/>
	 * Notifieur pour écrire aux Users.<br/>
	 */
	private INotifieur notifieur;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(NotifieurAdvice.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR NotifieurAdvice() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public NotifieurAdvice() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method getNotifieur() :<br/>
	 * Getter du Notifieur pour écrire aux Users.<br/>
	 * <br/>
	 *
	 * @return notifieur : INotifieur.<br/>
	 */
	public final INotifieur getNotifieur() {
		return this.notifieur;
	} // Fin de getNotifieur().____________________________________________
	

	
	/**
	* method setNotifieur(
	* INotifieur pNotifieur) :<br/>
	* Setter du Notifieur pour écrire aux Users.<br/>
	* <br/>
	*
	* @param pNotifieur : INotifieur : 
	* valeur à passer à notifieur.<br/>
	*/
	public final void setNotifieur(INotifieur pNotifieur) {
		this.notifieur = pNotifieur;
	} // Fin de setNotifieur(...)._________________________________________
	
	
		
} // FIN DE LA CLASSE NotifieurAdvice.---------------------------------------

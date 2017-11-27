package levy.daniel.application.model.services.notifieurs.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.services.notifieurs.IMessage;

/**
 * class MessageString :<br/>
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
public class MessageString implements IMessage {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * message : String :<br/>
	 * Message à notifier.<br/>
	 */
	private String message;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(MessageString.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR MessageString() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public MessageString() {
		this(null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR MessageString(
	 * String pMessage) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à notifier.<br/>
	 */
	public MessageString(
			final String pMessage) {
		
		super();
		
		this.message = pMessage;
				
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result 
				+ ((this.message == null) ? 0 : this.message.hashCode());
		return result;
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(
			final Object pObj) {
		
		if (this == pObj) {
			return true;
		}
		
		if (pObj == null) {
			return false;
		}
		
		if (!(pObj instanceof MessageString)) {
			return false;
		}
		
		final MessageString other = (MessageString) pObj;
		
		if (this.message == null) {
			if (other.message != null) {
				return false;
			}
		} else if (!this.message.equals(other.message)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("MessageString [");
		
		if (this.message != null) {
			builder.append("message=");
			builder.append(this.message);
		}
		else {
			builder.append("message= null");
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * method getMessage() :<br/>
	 * Getter du Message à notifier.<br/>
	 * <br/>
	 *
	 * @return message : String.<br/>
	 */
	public final String getMessage() {
		return this.message;
	} // Fin de getMessage().______________________________________________


	
	/**
	* method setMessage(
	* String pMessage) :<br/>
	* Setter du Message à notifier.<br/><br/>
	* <br/>
	*
	* @param pMessage : String : valeur à passer à message.<br/>
	*/
	public final void setMessage(
			final String pMessage) {
		this.message = pMessage;
	} // Fin de setMessage(...).___________________________________________
	

		
} // FIN DE LA CLASSE MessageString.-----------------------------------------

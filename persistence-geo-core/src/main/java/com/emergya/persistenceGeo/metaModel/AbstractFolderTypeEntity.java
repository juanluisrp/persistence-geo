package com.emergya.persistenceGeo.metaModel;

/**
 * Entidad del tipo de carpeta
 * 
 * @author <a href="mailto:marcos@emergya.com">marcos</a>
 *
 */
public abstract class AbstractFolderTypeEntity extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4950765436808392406L;
	
	protected Long id;
	
	protected String type;
	
	public AbstractFolderTypeEntity(){
		
	}
	
	/**
	 * @return the id
	 */
	public abstract Long getId();
	
	/**
	 * @return the type
	 */
	public abstract String getType();
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}

/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.domain.md;

import flipkart.pdo.md.User2Group;
import flipkart.pdo.md.domain.User2GroupDomain;

import org.tentackle.domain.AbstractDomainObject;
import org.tentackle.pdo.DomainObjectService;

/**
 * Domain implementation for User2Group.
 */
@DomainObjectService(User2Group.class)
public class User2GroupDomainImpl extends AbstractDomainObject<User2Group, User2GroupDomainImpl> implements User2GroupDomain {

  /** serial version UID. */
  private static final long serialVersionUID = 1L;

  //<editor-fold defaultstate="collapsed" desc="constructors">

  /**
   * Creates a domain object for a PDO.
   *
   * @param pdo the persistent domain object
   */
  public User2GroupDomainImpl(User2Group pdo) {
    super(pdo);
  }

  /**
   * Creates a domain object.
   */
  public User2GroupDomainImpl() {
    super();
  }

  //</editor-fold>

  // @wurblet domainMethods DomainMethods

//<editor-fold defaultstate="collapsed" desc="code 'domainMethods' generated by wurblet DomainMethods">//GEN-BEGIN:domainMethods


//</editor-fold>//GEN-END:domainMethods

}

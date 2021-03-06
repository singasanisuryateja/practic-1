/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.domain.md;

import flipkart.pdo.md.User;
import flipkart.pdo.md.domain.UserDomain;

import org.tentackle.pdo.DomainObjectService;

/**
 * Domain implementation for User.
 */
@DomainObjectService(User.class)
public class UserDomainImpl extends OrgUnitDomainImpl<User, UserDomainImpl> implements UserDomain {

  /** serial version UID. */
  private static final long serialVersionUID = 1L;

  //<editor-fold defaultstate="collapsed" desc="constructors">

  /**
   * Creates a domain object for a PDO.
   *
   * @param pdo the persistent domain object
   */
  public UserDomainImpl(User pdo) {
    super(pdo);
  }

  /**
   * Creates a domain object.
   */
  public UserDomainImpl() {
    super();
  }

  //</editor-fold>

  // @wurblet domainMethods DomainMethods

//<editor-fold defaultstate="collapsed" desc="code 'domainMethods' generated by wurblet DomainMethods">//GEN-BEGIN:domainMethods


//</editor-fold>//GEN-END:domainMethods

}

/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.persist.md.rmi;

import flipkart.pdo.md.UserGroup;
import flipkart.persist.md.UserGroupPersistenceImpl;

import org.tentackle.dbms.rmi.RemoteDbSessionImpl;


/**
 * Remote delegate implementation for {@link UserGroupPersistenceImpl}.
 */
public class UserGroupRemoteDelegateImpl
       extends OrgUnitRemoteDelegateImpl<UserGroup,UserGroupPersistenceImpl>
       implements UserGroupRemoteDelegate {


  /**
   * Creates the remote delegate for {@link UserGroupPersistenceImpl}.
   *
   * @param session the RMI session
   * @param persistenceClass the persistence implementation class
   * @param pdoClass the pdo interface class
   */
  public UserGroupRemoteDelegateImpl(RemoteDbSessionImpl session, Class<UserGroupPersistenceImpl> persistenceClass, Class<UserGroup> pdoClass) {
    super(session, persistenceClass, pdoClass);
  }

  // @wurblet inclrmi Include --missingok .$classname/methods

//<editor-fold defaultstate="collapsed" desc="code 'inclrmi' generated by wurblet Include">//GEN-BEGIN:inclrmi


//</editor-fold>//GEN-END:inclrmi


}

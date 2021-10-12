/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.persist.rmi;

import org.tentackle.common.Service;
import org.tentackle.dbms.RemoteSessionFactory;
import org.tentackle.dbms.rmi.RemoteDbSession;
import org.tentackle.pdo.PdoRemoteSession;

/**
 * Application specific remote session factory.
 */
@Service(RemoteSessionFactory.class)
public class mvnRemoteSessionFactory implements RemoteSessionFactory {

  @Override
  public PdoRemoteSession create(RemoteDbSession remoteDbSession) {
    return new mvnRemoteSessionAdapter(remoteDbSession);
  }

}

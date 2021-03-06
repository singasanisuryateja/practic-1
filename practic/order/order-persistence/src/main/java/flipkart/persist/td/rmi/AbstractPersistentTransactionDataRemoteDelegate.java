/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.persist.td.rmi;

import flipkart.pdo.TransactionData;
import flipkart.persist.AbstractPersistentTransactionData;

import org.tentackle.persist.rmi.AbstractPersistentObjectRemoteDelegate;

/**
 * Base interface for transaction data remote delegates.
 *
 * @param <T> the {@code PersistentDomainObject} class
 * @param <P> the {@code AbstractPersistenObject} class (persistence implementation)
 */
public interface AbstractPersistentTransactionDataRemoteDelegate<T extends TransactionData<T>,
                                                                 P extends AbstractPersistentTransactionData<T,P>>
       extends AbstractPersistentObjectRemoteDelegate<T,P> {

}

/*
 * Generated by operation wizard.
 */

package ${persistencePackage};

import ${operationPackage}.${operationInterface};
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.PersistentOperation;

/**
 * Persistence interface for ${operationInterface}.
 */
<#if abstractOperation == "true">
public interface ${persistenceInterface}<T extends ${operationInterface}<T>> extends ${superPersistenceInterface}<T> {
<#else>
public interface ${persistenceInterface} extends ${superPersistenceInterface}<${operationInterface}> {
</#if>

}
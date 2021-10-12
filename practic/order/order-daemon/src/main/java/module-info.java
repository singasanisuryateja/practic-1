/*
 * mvn generated by tentackle-project-archetype.
 */

/**
 * Daemon client module.
 */
module flipkart.daemon {
  exports flipkart.daemon;

  requires flipkart.persist;
  requires flipkart.domain;

  requires java.rmi;

  provides org.tentackle.common.ModuleHook with flipkart.daemon.service.Hook;

  // SLF4J isnt a module yet. For some odd reason, we need a lookup scan for deps on the classpath.
  // Otherwise non-modularized deps cannot be located via META-INF/services.
  uses org.tentackle.log.Logger;
}
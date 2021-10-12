/*
 * mvn generated by tentackle-project-archetype.
 */

/**
 * Persistent Domain Object (PDO) module.
 */
module flipkart.pdo {
  exports flipkart.pdo;
  exports flipkart.pdo.md;
  exports flipkart.pdo.md.domain;
  exports flipkart.pdo.md.persist;
  exports flipkart.pdo.security;
  exports flipkart.pdo.td;
  exports flipkart.pdo.td.domain;
  exports flipkart.pdo.td.persist;

  requires transitive flipkart.common;

  provides org.tentackle.common.ModuleHook with flipkart.pdo.service.Hook;
}

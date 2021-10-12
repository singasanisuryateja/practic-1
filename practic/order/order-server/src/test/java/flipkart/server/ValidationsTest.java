/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.server;

import org.reflections.Reflections;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.tentackle.log.Logger;
import org.tentackle.pdo.PdoRuntimeException;
import org.tentackle.pdo.PersistentDomainObject;
import org.tentackle.script.ScriptFactory;
import org.tentackle.test.pdo.AbstractPdoTest;
import org.tentackle.validate.ValidationFailedException;
import org.tentackle.validate.ValidationUtilities;

/**
 * Runs a dummy validation for all PDOs.<br>
 * Detects scripting errors, etc...
 */
public class ValidationsTest extends AbstractPdoTest {

  @BeforeClass
  public void setup() {
    ScriptFactory.getInstance().setDefaultLanguage("groovy");
    ValidationUtilities.getInstance().configureTestMode(Logger.Level.INFO);
  }

  @AfterClass
  public void restore() {
    ValidationUtilities.getInstance().configureTestMode(null);
  }

  @Test
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void testValidation() {
    Reflections reflections = new Reflections("flipkart");
    reflections.getSubTypesOf(PersistentDomainObject.class).forEach(c -> {
      try {
        PersistentDomainObject pdo = on(c);
        Reporter.log("PDO " + c.getName() + "<br>");
        pdo.validate();
      }
      catch (PdoRuntimeException px) {
        Reporter.log("PDO " + c.getName() + " cannot be instantiated: " + px.getMessage() + "<br>");
      }
      catch (ValidationFailedException vx) {
        // this is ok: PDO not valid
      }
      catch (RuntimeException rx) {
        Assert.fail("validation of " + c.getName() + " failed", rx);
      }
    });
  }

}
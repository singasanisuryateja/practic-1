/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.client;

import org.tentackle.fx.FxFactory;
import org.tentackle.fx.rdc.app.LoginApplication;
import org.tentackle.fx.rdc.login.Login;

import java.net.URL;

/**
 * Login FX application with specific CSS configuration.
 */
public class mvnLoginApplication extends LoginApplication {

  @Override
  protected Login loadLoginController() {
    URL cssUrl = mvnLoginApplication.class.getResource("/flipkart/client/Login.css");
    Login loginController = FxFactory.getInstance().createController(Login.class, null, null, cssUrl);
    loginController.setInactivityTimeout(30);
    return loginController;
  }

}

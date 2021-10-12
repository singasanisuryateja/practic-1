/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.client;

import flipkart.common.mvnSessionInfo;
import flipkart.common.Version;
import flipkart.gui.GuiBundle;
import flipkart.gui.main.MainController;
import flipkart.pdo.md.User;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.tentackle.fx.rdc.app.FxApplication;
import org.tentackle.fx.rdc.update.UpdatableDesktopApplication;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.Pdo;
import org.tentackle.prefs.PersistedPreferencesFactory;


/**
 * The FX client application.
 */
@SuppressWarnings("unchecked")    // due to getUser() below
public class mvnFxClient extends UpdatableDesktopApplication<MainController> {

  /**
   * Creates the application.
   */
  public mvnFxClient() {
    super("FX-Client", Version.RELEASE);
  }

  @Override
  public Class<? extends FxApplication> getApplicationClass() {
    return mvnLoginApplication.class;
  }

  @Override
  public Class<MainController> getMainControllerClass() {
    return MainController.class;
  }

  @Override
  public void configureMainStage(Stage mainStage) {
    showApplicationStatus(GuiBundle.getString("initialize GUI..."), 0.9);
    super.configureMainStage(mainStage);
    mainStage.setTitle("mvn");
    mainStage.setOnCloseRequest((WindowEvent ev) -> {
      ev.consume();
      getMainController().exit();
    });
  }

  @Override
  protected void configurePreferences() {
    super.configurePreferences();
    User user = getUser(getDomainContext());    // must exist!
    PersistedPreferencesFactory.getInstance().setSystemOnly(user.isSystemPreferencesOnly());
    PersistedPreferencesFactory.getInstance().setReadOnly(!user.isChangingPreferencesAllowed());
  }

  @Override
  @SuppressWarnings("unchecked")
  public User getUser(DomainContext context, long userId) {
    return Pdo.create(User.class, context).selectCached(userId);
  }


  /**
   * Starts the FX client application.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    new mvnFxClient().start(args);
  }

}
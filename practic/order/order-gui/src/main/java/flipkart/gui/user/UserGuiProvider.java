/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.gui.user;

import flipkart.gui.mvnImageProvider;
import flipkart.pdo.md.User;
import flipkart.pdo.md.UserGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

import org.tentackle.fx.Fx;
import org.tentackle.fx.rdc.DefaultGuiProvider;
import org.tentackle.fx.rdc.GuiProviderService;
import org.tentackle.fx.rdc.PdoFinder;
import org.tentackle.fx.rdc.search.DefaultPdoFinder;
import org.tentackle.misc.IdentifiableKey;
import org.tentackle.pdo.PersistentDomainObject;

import java.util.Collection;

/**
 * GUI provider for User.
 */
@GuiProviderService(User.class)
public class UserGuiProvider extends DefaultGuiProvider<User> {

  /**
   * Creates the provider.
   *
   * @param pdo the pdo
   */
  public UserGuiProvider(User pdo) {
    super(pdo);
  }

  @Override
  public ImageView createIcon() {
    return Fx.createImageView(mvnImageProvider.REALM, "user");
  }

  @Override
  @SuppressWarnings("unchecked")
  public UserEditor createEditor() {
    return Fx.load(UserEditor.class);
  }

  @Override
  public boolean editorExists() {
    return true;
  }

  @Override
  public boolean finderExists() {
    return true;
  }

  @Override
  public PdoFinder<User> createFinder() {
    @SuppressWarnings("unchecked")
    PdoFinder<User> finder = Fx.load(DefaultPdoFinder.class);
    finder.setSearchRunningImmediately(true);
    return finder;
  }

  @Override
  public boolean providesTreeChildObjects() {
    return getPdo().isViewAllowed();
  }

  @Override
  public <P extends PersistentDomainObject<P>> Collection<? extends PersistentDomainObject<?>> getTreeChildObjects(P parent) {
    return getPdo().getUserGroups();
  }

  @Override
  public boolean isDragAccepted(DragEvent event) {
    IdentifiableKey<PersistentDomainObject<?>> key = getPdoKeyFromDragboard(event.getDragboard());
    if (key != null && UserGroup.class.equals(key.getIdentifiableClass())) {
      // check if group not already added
      for (UserGroup group: getPdo().getUserGroups()) {
        if (!group.isEditAllowed() || key.getIdentifiableId() == group.getId()) {
          return false;
        }
      }
      event.acceptTransferModes(TransferMode.COPY);
      return true;
    }
    return false;
  }

  @Override
  public void dropPdo(PersistentDomainObject<?> pdoToDrop) {
    if (pdoToDrop instanceof UserGroup) {
      UserGroup group = (UserGroup) pdoToDrop;
      User user = getPdo().reload();
      if (user.isEditAllowed() && !user.getUserGroups().contains(group)) {   // check again for sure
        user.getUserGroups().add(group);
        user.save();
      }
    }
  }

}

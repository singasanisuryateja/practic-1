/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.gui.usergroup;

import flipkart.pdo.md.User;
import flipkart.pdo.md.UserGroup;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableRow;
import javafx.stage.Modality;

import org.tentackle.bind.Bindable;
import org.tentackle.fx.FxControllerService;
import org.tentackle.fx.component.FxTableView;
import org.tentackle.fx.component.FxTextArea;
import org.tentackle.fx.component.FxTextField;
import org.tentackle.fx.rdc.PdoEditor;
import org.tentackle.fx.rdc.Rdc;
import org.tentackle.fx.rdc.RdcFactory;
import org.tentackle.fx.rdc.table.TablePopup;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.Pdo;

import java.util.List;
import java.util.ResourceBundle;



/**
 * Editor for UserGroup.
 */
@FxControllerService
public class UserGroupEditor extends PdoEditor<UserGroup> {

  @Bindable
  private UserGroup group;

  @FXML
  private FxTextField groupNameField;

  @FXML
  private FxTextArea groupCommentField;

  @FXML
  private FxTableView<User> groupUsersNode;

  @FXML
  private ResourceBundle resources;

  private TablePopup<User> popup;

  @FXML
  private void initialize() {
    groupUsersNode.setRowFactory(t -> {
      TableRow<User> row = new TableRow<>();
      row.setContextMenu(createContextMenu(row));
      return row;
    });
    Label emptyLabel = new Label(resources.getString("no users"));
    emptyLabel.setContextMenu(createContextMenu(null));
    groupUsersNode.setPlaceholder(emptyLabel);

    popup = RdcFactory.getInstance().createTablePopup(groupUsersNode, "UserGroupEditor", resources.getString("Users"));
  }

  @Override
  public UserGroup getPdo() {
    return group;
  }

  @Override
  public void setPdo(UserGroup pdo) {
    this.group = pdo;
    getBinder().putBindingProperty(DomainContext.class, pdo.getDomainContext());
  }

  @Override
  public void requestInitialFocus() {
    groupNameField.requestFocus();
  }

  @Override
  public void configure() {
    popup.loadPreferences();
  }

  @SuppressWarnings("unchecked")
  private ContextMenu createContextMenu(TableRow<User> row) {
    ContextMenu contextMenu = new ContextMenu();

    MenuItem addMenuItem = new MenuItem(resources.getString("add user to group"));
    addMenuItem.setOnAction(e -> {
      Rdc.displaySearchStage(
          Pdo.create(User.class, getBinder().getBindingProperty(DomainContext.class)),
          Modality.APPLICATION_MODAL, getStage(), true, users -> {
            if (!users.isEmpty()) {
              User user = users.get(0);
              if (!groupUsersNode.getItems().contains(user)) {
                ((List<User>) ((SortedList<User>) groupUsersNode.getItems()).getSource()).add(user);
                groupUsersNode.triggerViewModified();
              }
            }
          });
    });
    contextMenu.getItems().add(addMenuItem);

    if (row != null) {
      MenuItem removeMenuItem = new MenuItem(resources.getString("remove user from group"));
      removeMenuItem.disableProperty().bind(row.emptyProperty());
      removeMenuItem.setOnAction(e -> {
        ((SortedList<User>) groupUsersNode.getItems()).getSource().remove(row.getItem());
        groupUsersNode.triggerViewModified();
      });
      contextMenu.getItems().add(removeMenuItem);
    }

    return contextMenu;
  }

  @Override
  public String getValidationPath() {
    return "group";
  }

}

/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.pdo.md.persist;

import flipkart.pdo.md.User;
import flipkart.pdo.md.User2Group;
import flipkart.pdo.md.UserGroup;

import org.tentackle.bind.Bindable;
import org.tentackle.misc.TrackedList;
import org.tentackle.pdo.PersistentObject;
import org.tentackle.session.Persistent;

/**
 * Persistence interface for User2Group.
 */
public interface User2GroupPersistence extends PersistentObject<User2Group> {

  // @wurblet attributeNames AttributeNames

  //<editor-fold defaultstate="collapsed" desc="code 'attributeNames' generated by wurblet AttributeNames">//GEN-BEGIN:attributeNames


  /** relation name for 'User user via userId (User)'. */
  String RN_USER = "user";

  /** relation name for 'UserGroup userGroup via userGroupId (UserGroup)'. */
  String RN_USERGROUP = "userGroup";

  /** attribute name for database column 'group_id'. */
  String AN_USERGROUPID = "userGroupId";

  /** attribute name for database column 'user_id'. */
  String AN_USERID = "userId";

  //</editor-fold>//GEN-END:attributeNames


  // @wurblet columnLenghts ColumnLengths

//<editor-fold defaultstate="collapsed" desc="code 'columnLenghts' generated by wurblet ColumnLengths">//GEN-BEGIN:columnLenghts


//</editor-fold>//GEN-END:columnLenghts


  // @wurblet methods Methods

  //<editor-fold defaultstate="collapsed" desc="code 'methods' generated by wurblet Methods">//GEN-BEGIN:methods


  /**
   * Gets the attribute userGroupId.
   *
   * @return user group ID
   */
  @Persistent(ordinal=0, comment="user group ID")
  @Bindable(options="AUTOSELECT")
  long getUserGroupId();

  /**
   * Sets the attribute userGroupId.
   *
   * @param userGroupId user group ID
   */
  @Bindable
  void setUserGroupId(long userGroupId);

  /**
   * Gets the attribute userId.
   *
   * @return user ID
   */
  @Persistent(ordinal=1, comment="user ID")
  @Bindable(options="AUTOSELECT")
  long getUserId();

  /**
   * Sets the attribute userId.
   *
   * @param userId user ID
   */
  @Bindable
  void setUserId(long userId);

  //</editor-fold>//GEN-END:methods


  // @wurblet relations Relations

  //<editor-fold defaultstate="collapsed" desc="code 'relations' generated by wurblet Relations">//GEN-BEGIN:relations


  /**
   * Gets User user via userId (User).
   *
   * @return user User
   */
  @Bindable
  @Persistent(ordinal=0, comment="User", component=false, parent=true)
  User getUser();

  /**
   * Sets User user via userId (User).
   *
   * @param user User
   */
  @Bindable(options="AUTOSELECT")
  void setUser(User user);

  /**
   * Gets UserGroup userGroup via userGroupId (UserGroup).
   *
   * @return userGroup UserGroup
   */
  @Bindable
  @Persistent(ordinal=1, comment="UserGroup", component=false, parent=true)
  UserGroup getUserGroup();

  /**
   * Sets UserGroup userGroup via userGroupId (UserGroup).
   *
   * @param userGroup UserGroup
   */
  @Bindable(options="AUTOSELECT")
  void setUserGroup(UserGroup userGroup);

  /**
   * Selects composite list of User2Group nmLinks via User2Group#userId (NmLinks).
   *
   * @param userId user ID
   * @return NmLinks
   */
  TrackedList<User2Group> selectByUserId(long userId);

  /**
   * Selects composite list of User2Group nmLinks via User2Group#userGroupId (NmLinks).
   *
   * @param userGroupId user group ID
   * @return NmLinks
   */
  TrackedList<User2Group> selectByUserGroupId(long userGroupId);

  //</editor-fold>//GEN-END:relations

}

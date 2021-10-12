/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.pdo.security;

import flipkart.pdo.md.User;
import flipkart.pdo.md.User2Group;
import flipkart.pdo.md.UserGroup;

import org.tentackle.log.Logger;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.Pdo;
import org.tentackle.security.DefaultSecurityManager;
import org.tentackle.security.GranteeDescriptor;
import org.tentackle.security.Permission;
import org.tentackle.security.SecurityFactory;
import org.tentackle.security.SecurityResult;
import org.tentackle.session.SessionUtilities;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Application specific security manager.<br>
 * Implements the user to group relationship.
 */
public class mvnSecurityManager extends DefaultSecurityManager {

  private static final Logger LOGGER = Logger.get();

  private final int userClassId;
  private final int groupClassId;
  private final int user2GroupClassId;
  private final SecurityResult userGroupResult;

  /**
   * Creates the security manager.
   */
  public mvnSecurityManager() {
    // re-initialize on every changed user or group
    Pdo.listen(this::invalidate, User.class, UserGroup.class);
    userClassId = SessionUtilities.getInstance().getClassId(User.class.getName());
    groupClassId = SessionUtilities.getInstance().getClassId(UserGroup.class.getName());
    user2GroupClassId = SessionUtilities.getInstance().getClassId(User2Group.class.getName());
    userGroupResult = createAcceptedSecurityResult("user/group", true);
    LOGGER.info("userClassId={0}, groupClassId={1}, user2GroupClassId={2}", userClassId, groupClassId, user2GroupClassId);
  }


  @Override
  public Collection<GranteeDescriptor> determineGranteesToCheck(DomainContext context, GranteeDescriptor grantee) {
    boolean log = LOGGER.isInfoLoggable();
    StringBuilder buf = log ? new StringBuilder() : null;
    Collection<GranteeDescriptor> grantees = new ArrayList<>();

    // check rules for user
    grantees.add(grantee);

    // check rules for groups this user belongs to
    User user = Pdo.create(User.class, context).selectCached(grantee.getGranteeId());
    if (log) {
      buf.append("user ").append(user).append(" / grantee ").append(grantee).append(":");
    }
    for (UserGroup group : user.getUserGroups()) {
      GranteeDescriptor groupGrantee = new GranteeDescriptor(group);
      grantees.add(groupGrantee);
      if (log) {
        buf.append("\n-> group ").append(group).append(" / grantee ").append(groupGrantee);
      }
    }
    if (log) {
      LOGGER.info(buf.toString());
    }

    // check rules for all
    grantees.add(new GranteeDescriptor(0, 0));

    return grantees;
  }

  @Override
  protected SecurityResult evaluateImpl(DomainContext context, Permission permission, int objectClassId, long objectId,
          Class<?> clazz) {
    // allow read permission for user and usergroups (prevents invocation loop in determineGranteesToCheck above)
    if ((objectClassId == userClassId || objectClassId == groupClassId || objectClassId == user2GroupClassId) &&
        SecurityFactory.getInstance().getReadPermission().equals(permission)) {
      return userGroupResult;
    }
    return super.evaluateImpl(context, permission, objectClassId, objectId, clazz);
  }

}

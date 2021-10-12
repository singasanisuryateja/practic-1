/*
 * mvn generated by tentackle-project-archetype.
 */

package flipkart.persist.md;

import flipkart.pdo.md.User;
import flipkart.pdo.md.User2Group;
import flipkart.pdo.md.UserGroup;
import flipkart.pdo.md.persist.User2GroupPersistence;
import flipkart.persist.AbstractPersistentMasterData;
import flipkart.persist.md.rmi.User2GroupRemoteDelegate;

import org.tentackle.dbms.PreparedStatementWrapper;
import org.tentackle.dbms.ResultSetWrapper;
import org.tentackle.dbms.StatementId;
import org.tentackle.misc.TrackedList;
import org.tentackle.pdo.DomainContext;
import org.tentackle.pdo.PersistentObjectService;
import org.tentackle.persist.PersistentObjectClassVariables;
import org.tentackle.session.PersistenceException;
import org.tentackle.session.Session;
import org.tentackle.sql.Backend;

import java.rmi.RemoteException;

/**
 * Persistence implementation for User2Group.
 */
@PersistentObjectService(User2Group.class)
public class User2GroupPersistenceImpl extends AbstractPersistentMasterData<User2Group, User2GroupPersistenceImpl> implements User2GroupPersistence {

  /** serial version UID. */
  private static final long serialVersionUID = -1;

  // @wurblet classVariables ClassVariables

  //<editor-fold defaultstate="collapsed" desc="code 'classVariables' generated by wurblet ClassVariables">//GEN-BEGIN:classVariables

  /** Variables common to all instances of User2GroupPersistenceImpl. */
  public static final PersistentObjectClassVariables<User2Group, User2GroupPersistenceImpl> CLASSVARIABLES =
            PersistentObjectClassVariables.create(
                    User2Group.class,
                    User2GroupPersistenceImpl.class,
                    "u2g",
                    null,
                    null);

  @Override
  public PersistentObjectClassVariables<User2Group, User2GroupPersistenceImpl> getClassVariables() {
    return CLASSVARIABLES;
  }

  //</editor-fold>//GEN-END:classVariables


  // @wurblet columnNames ColumnNames

  //<editor-fold defaultstate="collapsed" desc="code 'columnNames' generated by wurblet ColumnNames">//GEN-BEGIN:columnNames


  /** database column name for 'userGroupId'. */
  public static final String CN_USERGROUPID = "group_id";

  /** database column name for 'userId'. */
  public static final String CN_USERID = "user_id";

  //</editor-fold>//GEN-END:columnNames


  // @wurblet declare Declare

  //<editor-fold defaultstate="collapsed" desc="code 'declare' generated by wurblet Declare">//GEN-BEGIN:declare


  /** user group ID. */
  private long userGroupId;

  /** user ID. */
  private long userId;

  //</editor-fold>//GEN-END:declare


  //<editor-fold defaultstate="collapsed" desc="constructors">

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   * @param context the domain context
   */
  public User2GroupPersistenceImpl(User2Group pdo, DomainContext context) {
    super(pdo, context);
  }

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   * @param session the session
   */
  public User2GroupPersistenceImpl(User2Group pdo, Session session) {
    super(pdo, session);
  }

  /**
   * Creates a persistent object for a PDO.
   *
   * @param pdo the persistent domain object
   */
  public User2GroupPersistenceImpl(User2Group pdo) {
    super(pdo);
  }

  /**
   * Creates a persistent object.
   */
  public User2GroupPersistenceImpl() {
    super();
  }

  //</editor-fold>

  // @wurblet methods MethodsImpl

  //<editor-fold defaultstate="collapsed" desc="code 'methods' generated by wurblet MethodsImpl">//GEN-BEGIN:methods


  @Override
  public User2GroupRemoteDelegate getRemoteDelegate() {
    return (User2GroupRemoteDelegate) super.getRemoteDelegate();
  }

  @Override
  public boolean isTracked() {
    return true;    // invoking isModified() is ok
  }

  @Override
  public void getFields(ResultSetWrapper rs) {
    super.getFields(rs);
    if (rs.configureSection(CLASSVARIABLES)) {
      rs.configureColumn(CN_USERGROUPID);
      rs.configureColumn(CN_USERID);
      rs.configureColumn(CN_ID);
      rs.configureColumn(CN_SERIAL);
    }
    if (rs.getRow() <= 0) {
      throw new PersistenceException(getSession(), "no valid row");
    }
    userGroupId = rs.getLong();
    userId = rs.getLong();
    setId(rs.getLong());
    setSerial(rs.getLong());
  }

  @Override
  public int setFields(PreparedStatementWrapper st) {
    int ndx = super.setFields(st);
    st.setLong(++ndx, userGroupId);
    st.setLong(++ndx, userId);
    st.setLong(++ndx, getId());
    st.setLong(++ndx, getSerial());
    return ndx;
  }

  @Override
  public String createInsertSql() {
    return Backend.SQL_INSERT_INTO + getTableName() + Backend.SQL_LEFT_PARENTHESIS +
           CN_USERGROUPID + Backend.SQL_COMMA +
           CN_USERID + Backend.SQL_COMMA +
           CN_ID + Backend.SQL_COMMA +
           CN_SERIAL +
           Backend.SQL_INSERT_VALUES +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR_COMMA +
           Backend.SQL_PAR + Backend.SQL_RIGHT_PARENTHESIS;
  }

  @Override
  public String createUpdateSql() {
    return Backend.SQL_UPDATE + getTableName() + Backend.SQL_SET +
           CN_USERGROUPID + Backend.SQL_EQUAL_PAR_COMMA +
           CN_USERID + Backend.SQL_EQUAL_PAR_COMMA +
           CN_SERIAL + Backend.SQL_EQUAL + CN_SERIAL + Backend.SQL_PLUS_ONE +
           Backend.SQL_WHERE + CN_ID + Backend.SQL_EQUAL_PAR +
           Backend.SQL_AND + CN_SERIAL + Backend.SQL_EQUAL_PAR;
  }

  @Override
  public long getUserGroupId()    {
    return userGroupId;
  }

  @Override
  public void setUserGroupId(long userGroupId) {
    assertMutable();
    if (this.userGroupId != userGroupId) {
      setModified(true);
    }
    this.userGroupId = userGroupId;
  }

  @Override
  public long getUserId()    {
    return userId;
  }

  @Override
  public void setUserId(long userId) {
    assertMutable();
    if (this.userId != userId) {
      setModified(true);
    }
    this.userId = userId;
  }

  /**
   * Copies all attributes from a snapshot back to this object.
   *
   * @param snapshot the snapshot object
   */
  protected void revertAttributesToSnapshot(User2GroupPersistenceImpl snapshot) {
    super.revertAttributesToSnapshot(snapshot);
    userGroupId = snapshot.userGroupId;
    userId = snapshot.userId;
  }

  //</editor-fold>//GEN-END:methods


  // @wurblet relations PdoRelations

  //<editor-fold defaultstate="collapsed" desc="code 'relations' generated by wurblet PdoRelations">//GEN-BEGIN:relations


  @Override
  public User getUser()  {
    return userId == 0 ? null : on(User.class).selectCached(userId);
  }

  @Override
  public void setUser(User user)  {
    assertMutable();
    setUserId(user == null ? 0 : user.getId());
  }

  @Override
  public UserGroup getUserGroup()  {
    return userGroupId == 0 ? null : on(UserGroup.class).selectCached(userGroupId);
  }

  @Override
  public void setUserGroup(UserGroup userGroup)  {
    assertMutable();
    setUserGroupId(userGroup == null ? 0 : userGroup.getId());
  }

  // selects composite list of User2Group nmLinks via User2Group#userId (NmLinks)
  // @wurblet selectByUserId PdoSelectList --tracked userId

  // selects composite list of User2Group nmLinks via User2Group#userGroupId (NmLinks)
  // @wurblet selectByUserGroupId PdoSelectList --tracked userGroupId

  //</editor-fold>//GEN-END:relations

  //<editor-fold defaultstate="collapsed" desc="code 'selectByUserId' generated by wurblet PdoSelectList/PdoRelations">//GEN-BEGIN:selectByUserId


  private static final StatementId SELECT_BY_USER_ID_STMT = new StatementId();

  @Override
  public TrackedList<User2Group> selectByUserId(long userId) {
    if (getSession().isRemote())  {
      try {
        TrackedList<User2Group> list = getRemoteDelegate().selectByUserId(getDomainContext(), userId);
        configureRemoteObjects(getDomainContext(), list);
        return list;
      }
      catch (RemoteException e) {
        throw PersistenceException.createFromRemoteException(this, e);
      }
    }
    PreparedStatementWrapper st = getPreparedStatement(SELECT_BY_USER_ID_STMT,
      () -> {
        StringBuilder sql = createSelectAllInnerSql();
        sql.append(Backend.SQL_AND);
        sql.append(getColumnName(CN_USERID));
        sql.append(Backend.SQL_EQUAL_PAR);
        getBackend().buildSelectSql(sql, false, 0, 0);
        return sql.toString();
      }
    );
    int ndx = 1;
    st.setLong(ndx, userId);
    return executeTrackedListQuery(st);
  }

  //</editor-fold>//GEN-END:selectByUserId

  //<editor-fold defaultstate="collapsed" desc="code 'selectByUserGroupId' generated by wurblet PdoSelectList/PdoRelations">//GEN-BEGIN:selectByUserGroupId


  private static final StatementId SELECT_BY_USER_GROUP_ID_STMT = new StatementId();

  @Override
  public TrackedList<User2Group> selectByUserGroupId(long userGroupId) {
    if (getSession().isRemote())  {
      try {
        TrackedList<User2Group> list = getRemoteDelegate().selectByUserGroupId(getDomainContext(), userGroupId);
        configureRemoteObjects(getDomainContext(), list);
        return list;
      }
      catch (RemoteException e) {
        throw PersistenceException.createFromRemoteException(this, e);
      }
    }
    PreparedStatementWrapper st = getPreparedStatement(SELECT_BY_USER_GROUP_ID_STMT,
      () -> {
        StringBuilder sql = createSelectAllInnerSql();
        sql.append(Backend.SQL_AND);
        sql.append(getColumnName(CN_USERGROUPID));
        sql.append(Backend.SQL_EQUAL_PAR);
        getBackend().buildSelectSql(sql, false, 0, 0);
        return sql.toString();
      }
    );
    int ndx = 1;
    st.setLong(ndx, userGroupId);
    return executeTrackedListQuery(st);
  }

  //</editor-fold>//GEN-END:selectByUserGroupId

}

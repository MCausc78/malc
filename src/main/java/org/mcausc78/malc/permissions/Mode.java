package org.mcausc78.malc.permissions;

public class Mode {
    private RWX ownerPermissions = new RWX(true, true, true);
    private RWX groupPermissions = new RWX();
    private RWX usersPermissions = new RWX();
    public Mode() {}
    public RWX getOwnerPermissions() {
        return this.ownerPermissions;
    }
    public RWX getGroupPermissions() {
        return this.groupPermissions;
    }
    public RWX getUsersPermissions() {
        return this.usersPermissions;
    }
    public void setOwnerPermissions(RWX perms) {
        if (perms == null) throw new NullPointerException("perms field is null");
        this.ownerPermissions = perms;
    }
    public void setGroupPermissions(RWX perms) {
        if (perms == null) throw new NullPointerException("perms field is null");
        this.groupPermissions = perms;
    }
    public void setUsersPermissions(RWX perms) {
        if (perms == null) throw new NullPointerException("perms field is null");
        this.usersPermissions = perms;
    }
    public String toString() {
        return String.valueOf(this.getOwnerPermissions().toInt()) + String.valueOf(this.getGroupPermissions().toInt()) + String.valueOf(this.getUsersPermissions().toInt());
    }
}
